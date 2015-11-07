package dsa.common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="SONDERFERTIGKEIT")
public class Sonderfertigkeit implements java.io.Serializable {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="SONDERFERTIGKEIT_ID")
	private Long id;
	private Integer name;
	// TODO: Kosten
	private String voraussetzung;
	// TODO: Auswirkung als Wirkung-Object
	private String auswirkung;
	/*--------------------   Constructor Area --------------------*/
	public Sonderfertigkeit() {
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
	public Integer getName() {
		return name;
	}
	public void setName(Integer name) {
		this.name = name;
	}
	public String getVoraussetzung() {
		return voraussetzung;
	}
	public void setVoraussetzung(String voraussetzung) {
		this.voraussetzung = voraussetzung;
	}
	public String getAuswirkung() {
		return auswirkung;
	}
	public void setAuswirkung(String auswirkung) {
		this.auswirkung = auswirkung;
	}
}
