package dsa.common.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import dsa.common.data.charaktermappings.CharakterEigenschaft;

@Entity
@Table(name="EIGENSCHAFT")
public class Eigenschaft {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="EIGENSCHAFT_ID")
	private Long id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.eigenschaft")
	private List<CharakterEigenschaft> charakterEigenschaften;
	private String beschreibung;
	/*--------------------   Constructor Area --------------------*/
	public Eigenschaft() {
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
	public List<CharakterEigenschaft> getCharakterEigenschaften() {
		return charakterEigenschaften;
	}
	public void setCharakterEigenschaften(List<CharakterEigenschaft> charakterEigenschaften) {
		this.charakterEigenschaften = charakterEigenschaften;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
}
