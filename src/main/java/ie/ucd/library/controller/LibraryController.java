package ie.ucd.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;

@Controller
public class LibraryController {

	@Autowired private JavaMailSender javaMailSender;
    @Autowired private UserRepository userRepository;
    @Autowired private ArtifactRepository artifactRepository;
    @Autowired private Session session;
    @Autowired private LoanRepository loanRepository;

    @GetMapping("/")
    public String home(Model model) {
        if(session.getCurrentUser() == null) {
            model.addAttribute("loggedIn", "false");
        }
    	return "home.html";
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        if(session.getCurrentUser() == null)
            model.addAttribute("loggedIn", "false");
        return "login.html"; 
    }
    @PostMapping("/login")
    public void loginPost(@RequestParam(name="username")String username, @RequestParam(name="password") String password, HttpServletResponse response) throws Exception {
        Optional<User> user = userRepository.findByIdAndPassword(Integer.parseInt(username), password);
        if(user.isPresent()) {
            session.setUser(user.get());
            response.sendRedirect("/user");
        }
    }

    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("loggedIn", "false");
        return "register.html";
    }

    @PostMapping("/register")
    public void registerPost(@RequestParam(name="name") String name, @RequestParam(name="password") String password, @RequestParam(name="email") String email,
     @RequestParam(name="dob") String dob, HttpServletResponse response) throws Exception {
        User newUser = new User(name, password, email, dob);
        userRepository.save(newUser);
        session.setUser(newUser);
//        sendEmail(email, newUser.getId());
        response.sendRedirect("/user");
    }

    @GetMapping("/user")
    public String userGet(Model model) {
        User u = session.getCurrentUser();
        model.addAttribute("user", u);
        return "user.html";
    }

    @GetMapping("/addArtifact")
    public String addArtifactGet() {
        return "addArtifact.html";
    }

    @PostMapping("/addArtifact")
    public String addArtifactPost(@RequestParam(name="name") String name, @RequestParam(name="type") String type) throws SQLException {
        Artifact artifact = new Artifact();
        artifact.setName(name);
        artifact.setType(type);
        artifactRepository.save(artifact);
        return "addArtifact.html";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name="search") String search, Model model) {
        List<Artifact> artifacts = artifactRepository.findAll();
        Collections.sort(artifacts);
        removeDuplicates(artifacts);
        List<Artifact> searchResults = new ArrayList<Artifact>();

        for(Artifact artifact : artifacts)
            if(artifact.getType().toLowerCase().contains(search.toLowerCase()) || artifact.getName().toLowerCase().contains(search.toLowerCase()) )
                searchResults.add(artifact);

        model.addAttribute("artifacts", searchResults);
        model.addAttribute("searchQuery", search);
        if(session.getCurrentUser() == null)
            model.addAttribute("loggedIn", "false");
        else
            model.addAttribute("currentUser", session.getCurrentUser().getId());

    	return "searchResults.html";
    }

    @GetMapping("/search")
    public String searchGet(@RequestParam(name="search") String search, Model model) {
        List<Artifact> artifacts = artifactRepository.findAll();
        Collections.sort(artifacts);
        removeDuplicates(artifacts);
        List<Artifact> searchResults = new ArrayList<Artifact>();
        for(Artifact artifact : artifacts)
            if(artifact.getType().toLowerCase().contains(search.toLowerCase()) || artifact.getName().toLowerCase().contains(search.toLowerCase()) )
                searchResults.add(artifact);

        model.addAttribute("artifacts", searchResults);
        model.addAttribute("searchQuery", search);
        if(session.getCurrentUser() == null)
            model.addAttribute("loggedIn", "false");
        else
            model.addAttribute("currentUser", session.getCurrentUser().getId());

        return "searchResults.html";
    }

    @GetMapping("/viewLoans")
    public String getLoans(Model model) {
        List<Artifact> artifacts = artifactRepository.findByOwner(session.getCurrentUser().getId());
        model.addAttribute("artifacts", artifacts);
        return "viewLoans.html";
    }

    @GetMapping("/loanHistory")
    public String getLoanHistory(Model model) {
        /*List<Artifact> artifacts = artifactRepository.findAll();*/
        List<Loan> loans = loanRepository.findByOwner(session.getCurrentUser().getId());
        List<Loan> loanHistory = new ArrayList<>();
        System.out.println();
        for(Loan loan : loans) {
            if(!loan.getActive())
                loanHistory.add(loan);
        }
        model.addAttribute("loans", loanHistory);
        return "loanHistory.html";
    }

    @GetMapping("/logout")
    public void logout(HttpServletResponse response) throws Exception {
        session.setUser(null);
        response.sendRedirect("/");
    }

    @PostMapping("/edit")
    public void edit(@RequestParam(name="name") String name, @RequestParam(name="password") String password, @RequestParam(name="email") String email,
     @RequestParam(name="dob") String dob, HttpServletResponse response) throws Exception {
        User user = session.getCurrentUser();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setDateOfBirth(dob);
        response.sendRedirect("/user");
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        User u = session.getCurrentUser();
        model.addAttribute("user", u);
        return "edit.html";
    }

    @GetMapping("/takeOutLoan")
    public void takeOutLoan(@RequestParam(name="search") String search, @RequestParam(name="id") int id, HttpServletResponse response) throws Exception {
        Optional<Artifact> artifactOptional = artifactRepository.findById(id);
        LoanDate loanDate = new LoanDate();
        if(artifactOptional.isPresent()) {
            Artifact artifact = artifactOptional.get();
            artifact.setOwner(session.getCurrentUser().getId());
            artifact.setOnLoan(true);
            artifact.setDateCreated(loanDate.getLoanDate());
            artifact.setDateExpires(loanDate.getReturnDate());
            Loan loan = new Loan(artifact.getOwner(), artifact.getName(), artifact.getDateCreated(), artifact.getDateExpires(), artifact.getType());
            artifactRepository.save(artifact);
            loanRepository.save(loan);
        }
        response.sendRedirect("/search?search="+search);
    }

    @GetMapping("/reserve")
    public void reserve(@RequestParam(name="search") String search, @RequestParam(name="id") int id, HttpServletResponse response) throws Exception {
        Optional<Artifact> artifactOptional = artifactRepository.findById(id);
        if(artifactOptional.isPresent()) {
            Artifact artifact = artifactOptional.get();
            artifact.setReserver(session.getCurrentUser().getId());
            artifact.setReserved(true);
            artifactRepository.save(artifact);
        }
        response.sendRedirect("/search?search="+search);
    }

    void sendEmail(String emailAddress, int id) {
    	SimpleMailMessage msg = new SimpleMailMessage();
    	msg.setTo(emailAddress);
    	msg.setSubject("Username login");
    	msg.setText("Your unique Login ID is " + id);

    	javaMailSender.send(msg);
    }
    void removeDuplicates(List<Artifact> artifacts) {
        int i;

        /*for(Artifact a : artifacts)
            System.out.println(a.getName() + ", " + a.getOnLoan());*/

        for(i = 0;i < artifacts.size()-1;i++) {
            Integer owner = artifacts.get(i).getOwner();
            Integer reserver = artifacts.get(i).getReserver();
            boolean ownerFound = false;
            boolean reserverFound = false;

            if(owner != null)
                ownerFound = true;
            if(reserver != null)
                reserverFound = true;


            if(ownerFound || reserverFound) {
                int j = i;
                while(artifacts.get(j + 1).getArtifactId() == artifacts.get(j).getArtifactId()) {
                    Artifact temp = artifacts.get(j + 1);
                    artifacts.set(j + 1, artifacts.get(j));
                    artifacts.set(j, temp);
                }
            }
        }

        /*for(Artifact a : artifacts)
            System.out.println(a.getName() + ", " + a.getOnLoan());*/

        for(i = artifacts.size()-1;i > 0;i--)
            if(artifacts.get(i).getArtifactId() == artifacts.get(i - 1).getArtifactId())
                artifacts.remove(i - 1);

        /*for(Artifact a : artifacts)
            System.out.println(a.getName() + ", " + a.getOnLoan());*/
    }
}