package ie.ucd.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="artifacts")
public class Artifact implements Comparable<Artifact>{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; 
	@Column(name="artifact_id") private int artifactId;
	@Column(name="name") private String name;
	@Column(name="type") private String type;
	@Column(name="ONLOAN") private boolean onLoan;
	@Column(name="owner") private Integer owner;
	@Column(name="reserved") private boolean reserved;
	@Column(name="renewed") private boolean renewed;
	@Column(name="reserver") private Integer reserver;
	@Column(name="datecreated") private String dateCreated;
	@Column(name="dateexpires") private String dateExpires;

	public Artifact() {
		this.onLoan = false;
		this.reserved = false;
		this.renewed = false;
	}

	public Artifact(String name, String type) {
		this.name = name;
		this.type = type;
		this.onLoan = false;
		this.reserved = false;
		this.renewed = false;
	}

	public Artifact(int artifactId, String name, String type, boolean onLoan, Integer owner, boolean reserved, Integer reserver) {
		this.artifactId = artifactId;
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

	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}
	public int getArtifactId() {
		return this.artifactId;
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

	public void setRenewed(boolean renewed) {
		this.renewed = renewed;
	}
	public boolean getRenewed() {
		return this.renewed;
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

	@Override
	public int compareTo(Artifact a) {
		if(this.getArtifactId() < a.getArtifactId())
			return -1;
		else if(this.getArtifactId() > a.getArtifactId())
			return 1;
		else{
			if(!this.getOnLoan() && a.getOnLoan())
				return 1;
			else if(this.getOnLoan() && !a.getOnLoan())
				return -1;
			else {
				if(!this.getReserved() && a.getReserved())
					return 1;
				else if(this.getReserved() && !a.getReserved())
					return -1;
				else
					return 0;
			}
		}
//		return this.getArtifactId().compareTo(a.getArtifactId());
	}
}