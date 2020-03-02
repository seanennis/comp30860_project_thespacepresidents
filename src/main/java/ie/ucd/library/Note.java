import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

//import java.util.Date;
//import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="users")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; 
	@Column private String name;
	@Column private String password;
	@Column private String email;
	@Column private Boolean isLibrarian;

	public User() {}

	public User(String name, String password, String email, Boolean isLibrarian) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.isLibrarian = isLibrarian;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}

	public void setIsLibrarian(Boolean isLibrarian) {
		this.isLibrarian = isLibrarian;
	}
	public Boolean isLibrarian() {
		return this.isLibrarian;
	}

}