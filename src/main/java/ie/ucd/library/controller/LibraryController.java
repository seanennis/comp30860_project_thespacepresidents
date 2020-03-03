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

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

@Controller
public class LibraryController {

	@Autowired private JavaMailSender javaMailSender;
    @Autowired private UserRepository userRepository;
    @Autowired private ArtifactRepository artifactRepository;
    @Autowired private Session session;

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
    public void registerPost(@RequestParam(name="name") String name, @RequestParam(name="password") String password, @RequestParam(name="email") String email, @RequestParam(name="dob") String dob, HttpServletResponse response) throws Exception {
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

    @PostMapping("/search")
    public String search(@RequestParam(name="search") String search, Model model) {
        List<Artifact> artifacts = artifactRepository.findAll();

        System.out.println(artifacts.get(0).getName());

        model.addAttribute("artifacts", artifacts);
        model.addAttribute("searchQuery", search);

    	return "searchResults.html";
    }

    @GetMapping("/search")
    public String searchGet(@RequestParam(name="search") String search, Model model) {
        List<Artifact> artifacts = artifactRepository.findAll();

        System.out.println(artifacts.get(0).getName());

        model.addAttribute("artifacts", artifacts);
        model.addAttribute("searchQuery", search);

        return "searchResults.html";
    }

    @GetMapping("/takeOutLoan")
    public void takeOutLoan(@RequestParam(name="search") String search, @RequestParam(name="id") int id, HttpServletResponse response) throws Exception {
        Optional<Artifact> artifactOptional = artifactRepository.findById(id);
        if(artifactOptional.isPresent()) {
            Artifact artifact = artifactOptional.get();
            artifact.setOwner(session.getCurrentUser().getId());
            artifact.setOnLoan(true);
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
}