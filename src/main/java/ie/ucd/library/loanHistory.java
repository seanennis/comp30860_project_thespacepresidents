package ie.ucd.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="loanhistory")
public class loanHistory{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; 
	@Column(name="owner") private Integer owner;
	@Column(name="artifact") private String artifactName
	@Column(name="datecreated") private String dateCreated;
	@Column(name="dateexpires") private String dateExpires;

	public Loan() {}

	public Loan(Integer owner, String artifact, String dateCreated, String dateExpires) {
		this.owner = owner;
		this.artifact = artifact;
		this.dateCreated = dateCreated;
		this.dateExprires = dateExprires;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}
	public int getOwner(){
		return owner;
	}
	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}
	public String getArtifact(){
		return artifact;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getArtifact(){
		return dateCreated;
	}
	public void setDateExpires(String dateExprires) {
		this.dateExpires = dateExpires;
	}
	public String getDateExpires(){
		return dateExpires;
	}
}