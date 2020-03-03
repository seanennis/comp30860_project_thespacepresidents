package ie.ucd.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

//import java.util.Date;
//import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="artifacts")
public class Artifact {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; 
	@Column private String name;
	@Column private String type;
	@Column private boolean onloan;
	@Column private String owner;
	@Column private boolean reserved
	@Column private String reserver;

	public User() {}

	public User(String name, String type, String owner, String reserver) {
		this.name = name;
		this.type = type;
		this.owner = owner;
		this.reserver = reserver;
		this.onloan = false;
		this.reserved = false;
	}


	public int getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwner() {
		return this.owner;
	}

	public void setIsLibrarian(boolean isLibrarian) {
		this.isLibrarian = isLibrarian;
	}
	public boolean isLibrarian() {
		return this.isLibrarian;
	}

	public void setReserver(String reserver) {
		this.reserver = reserver;
	}
	public String getReserver() {
		return this.reserver;
	}

}