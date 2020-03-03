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
@Table(name="artifact")
public class Artifact{
	@Column private int id;
	@Column private String name;
	@Column private String type;

	public Artifact() {}

	public Artifact(String owner, String reserver) {
	
		this.id = id;
		this.name = name;
		this.type = type;
	}


	public int getId() {
		return this.id;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwner() {
		return this.owner;
	}

	public void setOnLoan(boolean onloan) {
		this.onloan = onloan;
	}
	public boolean onLoan() {
		return this.onLoan;
	}

	public void setReserved(boolean setReserved) {
		this.reserved = reserved;
	}
	public boolean Reserved() {
		return this.reserved;
	}

	public void setReserver(String reserver) {
		this.reserver = reserver;
	}
	public String getReserver() {
		return this.reserver;
	}

}