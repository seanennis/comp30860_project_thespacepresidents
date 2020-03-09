package ie.ucd.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="loans")
public class Loan{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; 
	@Column(name="owner") private Integer owner;
	@Column(name="artifactid") private int artifactID;
	@Column(name="artifact") private String artifact;
	@Column(name="artifacttype") private String artifactType;
	@Column(name="datecreated") private String dateCreated;
	@Column(name="dateexpired") private String dateExpired;
	@Column(name="active") private boolean active;

	public Loan() {
		this.active = true;
	}

	public Loan(Integer owner, int artifactID, String artifact, String dateCreated, String dateExpired, String artifactType) {
		this.owner = owner;
		this.artifactID = artifactID;
		this.artifact = artifact;
		this.artifactType = artifactType;
		this.dateCreated = dateCreated;
		this.dateExpired = dateExpired;
		this.active = true;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}
	public int getOwner(){
		return owner;
	}
	public void setArtifactID(int artifactID) {
		this.artifactID = artifactID;
	}
	public int getArtifactID(){
		return artifactID;
	}
	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}
	public String getArtifact(){
		return artifact;
	}
		public void setArtifactType(String artifactType) {
		this.artifactType = artifactType;
	}
	public String getArtifactType(){
		return artifactType;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateCreated(){
		return dateCreated;
	}
	public void setDateExpired(String dateExprired) {
		this.dateExpired = dateExpired;
	}
	public String getDateExpired(){
		return dateExpired;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean getActive(){
		return active;
	}
}