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
@Table(name="loans")
public class Loan{
	@Column private int id; 
	@Column private String name;
	@Column private boolean onloan;
	@Column private String owner;
	@Column private boolean reserved;
	@Column private String reserver;

	public Loan() {}

	public Loan(int id, String owner, String reserver) {
	
		this.id = id;
		this.owner = owner;
		this.reserver = reserver;
		this.onloan = false;
		this.reserved = false;
	}

	public void setId(int id){
		this.id = id;
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
		return this.onloan;
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