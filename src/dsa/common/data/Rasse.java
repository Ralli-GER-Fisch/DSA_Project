package dsa.common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rasse")
public class Rasse {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="RASSE_ID")
	private Long id;
	private String name;
	private Integer generierungskosten;
	private String koerpergroesse_regel;
	private String geweicht_regel;
	@Column(name="LE_MOD")
	private Integer lebenspunkte_modifikator;
	@Column(name="AU_MOD")
	private Integer ausdauer_modifikator;
	@Column(name="MR_MOD")
	private Integer magieresistenz_modifikator;
	private String herkunft_verbreitung;
	private String koerperbau_aussehen;
	private String beschreibung;
	/*--------------------   Constructor Area --------------------*/
	public Rasse() {
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

	public String getKoerpergroesse_regel() {
		return koerpergroesse_regel;
	}

	public void setKoerpergroesse_regel(String koerpergroesse_regel) {
		this.koerpergroesse_regel = koerpergroesse_regel;
	}

	public String getGeweicht_regel() {
		return geweicht_regel;
	}

	public void setGeweicht_regel(String geweicht_regel) {
		this.geweicht_regel = geweicht_regel;
	}

	public Integer getLebenspunkte_modifikator() {
		return lebenspunkte_modifikator;
	}

	public void setLebenspunkte_modifikator(Integer lebenspunkte_modifikator) {
		this.lebenspunkte_modifikator = lebenspunkte_modifikator;
	}

	public Integer getAusdauer_modifikator() {
		return ausdauer_modifikator;
	}

	public void setAusdauer_modifikator(Integer ausdauer_modifikator) {
		this.ausdauer_modifikator = ausdauer_modifikator;
	}

	public Integer getMagieresistenz_modifikator() {
		return magieresistenz_modifikator;
	}

	public void setMagieresistenz_modifikator(Integer magieresistenz_modifikator) {
		this.magieresistenz_modifikator = magieresistenz_modifikator;
	}

	public String getHerkunft_verbreitung() {
		return herkunft_verbreitung;
	}

	public void setHerkunft_verbreitung(String herkunft_verbreitung) {
		this.herkunft_verbreitung = herkunft_verbreitung;
	}

	public String getKoerperbau_aussehen() {
		return koerperbau_aussehen;
	}

	public void setKoerperbau_aussehen(String koerperbau_aussehen) {
		this.koerperbau_aussehen = koerperbau_aussehen;
	}
}
