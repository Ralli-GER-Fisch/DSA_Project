package dsa.common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="vorteil")
public class Vorteil {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="VORTEIL_ID")
	private Long id;
	private String name;
	private String beschreibung;
	private Integer generierungskosten;
	private String kostenzusatz;
	//private String auswirkung;
	//private Wirkung auswirkung;
	/*--------------------   Constructor Area --------------------*/
	public Vorteil() {
	}
	public Vorteil(long id) {
		setId(id);
	}
	/*--------------------    Function   Area --------------------*/
	
	/*-------------------- Getter/Setter Area --------------------*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getGenerierungskosten() {
		return generierungskosten;
	}
	public void setGenerierungskosten(Integer generierungskosten) {
		this.generierungskosten = generierungskosten;
	}
	public String getKostenzusatz() {
		return kostenzusatz;
	}
	public void setKostenzusatz(String kostenzusatz) {
		this.kostenzusatz = kostenzusatz;
	}
	/*public String getAuswirkung() {
		return auswirkung;
	}
	public void setAuswirkung(String auswirkung) {
		this.auswirkung = auswirkung;
	}*/
}
