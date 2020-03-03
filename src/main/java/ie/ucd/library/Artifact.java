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
public class Artifact{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id; 
	@Column private String name;
	@Column private String type;

	public Artifact() {}

	public Artifact(String owner, String reserver) {
		this.name = name;
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName(String type) {
		return this.name;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}

}