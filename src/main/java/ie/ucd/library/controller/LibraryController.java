package ie.ucd.noteit;

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

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

@Controller
public class LibraryController {

	@Autowired
    private JavaMailSender javaMailSender;

	private Connection conn;
    private Statement stmt;

    @GetMapping("/")
    public String home(Model model) {
    	return "register.html";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name="search") String title, Model model) {
    	System.out.println(title);
    	return "searchResults.html";
    }

    void sendEmail(String emailAddress, String id) {
    	SimpleMailMessage msg = new SimpleMailMessage();
    	msg.setTo(emailAddress);
    	msg.setSubject("Unique ID");
    	msg.setText("Your unique ID is " + id);

    	javaMailSender.send(msg);
    }
}