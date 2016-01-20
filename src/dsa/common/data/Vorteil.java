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

import dsa.common.data.charaktermappings.CharakterVorteil;
@Entity
@Table(name="vorteil")
public class Vorteil {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="VORTEIL_ID")
	private Long id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.vorteil")
	private List<CharakterVorteil> charakterVorteil;
	private String name;
	private String beschreibung;
	private String auswirkung;
	//TODO: private Wirkung auswirkung;
	/*--------------------   Constructor Area --------------------*/
	public Vorteil() {
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
	public List<CharakterVorteil> getCharakterVorteil() {
		return charakterVorteil;
	}
	public void setCharakterVorteil(List<CharakterVorteil> charakterVorteil) {
		this.charakterVorteil = charakterVorteil;
	}
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
	public String getAuswirkung() {
		return auswirkung;
	}
	public void setAuswirkung(String auswirkung) {
		this.auswirkung = auswirkung;
	}
}
