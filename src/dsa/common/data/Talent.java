package dsa.common.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import dsa.common.data.charaktermappings.CharakterTalent;

@Entity
@Table(name="TALENT")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Talent {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="TALENT_ID")
	private Long id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.talent")
	private List<CharakterTalent> charakterTalent;
	private String name;
	/*--------------------   Constructor Area --------------------*/
	public Talent() {
		// TODO Auto-generated constructor stub
	}
	/*--------------------    Function   Area --------------------*/
	
	/*-------------------- Getter/Setter Area --------------------*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<CharakterTalent> getCharakterTalent() {
		return charakterTalent;
	}
	public void setCharakterTalent(List<CharakterTalent> charakterTalent) {
		this.charakterTalent = charakterTalent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
