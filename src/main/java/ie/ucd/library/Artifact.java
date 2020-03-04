package ie.ucd.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="artifacts")
public class Artifact{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; 
	@Column(name="name") private String name;
	@Column(name="type") private String type;
	@Column(name="ONLOAN") private boolean onLoan;
	@Column(name="owner") private Integer owner;
	@Column(name="reserved") private boolean reserved;
	@Column(name="reserver") private Integer reserver;
	@Column(name="datecreated") private String dateCreated;
	@Column(name="dateexpires") private String dateExpires;

	public Artifact() {}

	public Artifact(String name, String type) {
		this.name = name;
		this.type = type;
		this.onLoan = false;
		this.reserved = false;
	}

	public Artifact(String name, String type, boolean onLoan, Integer owner, boolean reserved, Integer reserver) {
		this.name = name;
		this.type = type;
		this.onLoan = onLoan;
		this.owner = owner;
		this.reserved = reserved;
		this.reserver = reserver;
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
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	public Integer getOwner() {
		return this.owner;
	}
	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}
	public boolean getOnLoan() {
		return this.onLoan;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public boolean getReserved() {
		return this.reserved;
	}

	public void setReserver(Integer reserver) {
		this.reserver = reserver;
	}
	public Integer getReserver() {
		return this.reserver;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateCreated() {
		return this.dateCreated;
	}

	public void setDateExpires(String dateExpires) {
		this.dateExpires = dateExpires;
	}
	public String getDateExpires() {
		return this.dateExpires;
	}
}