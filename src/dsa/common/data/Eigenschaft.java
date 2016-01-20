package dsa.common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="eigenschaft")
public class Eigenschaft {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="EIGENSCHAFT_ID")
	private Long id;
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.eigenschaft")
	//private List<CharakterEigenschaft> charakterEigenschaften;
	private String name;
	private String beschreibung;
	private String kuerzel;
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
	/*public List<CharakterEigenschaft> getCharakterEigenschaften() {
		return charakterEigenschaften;
	}
	public void setCharakterEigenschaften(List<CharakterEigenschaft> charakterEigenschaften) {
		this.charakterEigenschaften = charakterEigenschaften;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public String getKuerzel() {
		return kuerzel;
	}
	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().toString() +"{\nID: "+ id+"\nName: "+name+"\nKuerzel: "+kuerzel+"\nBeschreibung: "+ beschreibung+"\n}\n";
	}
}
