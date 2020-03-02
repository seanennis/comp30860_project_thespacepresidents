package ie.ucd.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

@Controller
public class LibraryController {

	@Autowired private JavaMailSender javaMailSender;
    @Autowired private UserRepository userRepository;
    @Autowired private Session session;

	private Connection conn;
    private Statement stmt;

    @GetMapping("/")
    public String home(Model model) {
    	return "register.html";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login.html"; 
    }
    @PostMapping("/login")
    public void loginPost(@RequestParam(name="username")String username, @RequestParam(name="password") String password) {
        Optional<User> user = userRepository.findByIdAndPassword(Integer.parseInt(username), password);
        if(user.isPresent()) {
            session.setUser(user.get());
            System.out.println(user.get().getEmail());
        }
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register.html";
    }

    @PostMapping("/register")
    public String registerPost(@RequestParam(name="name") String name, @RequestParam(name="password") String password, @RequestParam(name="email") String email, @RequestParam(name="dob") String dob) {
        User newUser = new User(name, password, email, dob);
        userRepository.save(newUser);
//        sendEmail(email, newUser.getId());
        return "register.html";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name="search") String title, Model model) {
    	System.out.println(title);
    	return "searchResults.html";
    }

    void sendEmail(String emailAddress, int id) {
    	SimpleMailMessage msg = new SimpleMailMessage();
    	msg.setTo(emailAddress);
    	msg.setSubject("Username login");
    	msg.setText("Your unique Login ID is " + id);

    	javaMailSender.send(msg);
    }
}