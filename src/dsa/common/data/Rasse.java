package dsa.common.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import dsa.common.data.mappings.Rasse_Eigenschaft_Mod;
import dsa.common.data.mappings.Rasse_Kultur;
import dsa.common.data.mappings.Rasse_Nachteil;
import dsa.common.data.mappings.Rasse_Talent_Mod;
import dsa.common.data.mappings.Rasse_Vorteil;

@Entity
@Table(name="rasse")
public class Rasse {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="RASSE_ID")
	private Long id;
	private String name;
	@Column(name="GENERIERUNGSKOSTEN")
	private Integer generierungskosten;
	@Column(name="KOERPERGROESSE_REGEL")
	private String koerpergroesse_regel;
	@Column(name="GEWICHT_REGEL")
	private String gewicht_regel;
	@Column(name="LE_MOD")
	private Integer lebenspunkte_modifikator;
	@Column(name="AU_MOD")
	private Integer ausdauer_modifikator;
	@Column(name="MR_MOD")
	private Integer magieresistenz_modifikator;
	@Column(name="HERKUNFT_VERBREITUNG")
	private String herkunft_verbreitung;
	@Column(name="KOERPERBAU_AUSSEHEN")
	private String koerperbau_aussehen;
	@Column(name="BESCHREIBUNG")
	private String beschreibung;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Rasse_Eigenschaft_Mod> eigenschafts_modifikatoren;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Rasse_Vorteil> rasse_vorteile;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Rasse_Nachteil> rasse_nachteile;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Rasse_Kultur> rasse_kulturen;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Rasse_Talent_Mod> rasse_talente;
	//@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	//private Set<Rasse_Sonderfertigkeit> rasse_sonderfertigkeiten;
	
	

	
	
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

	public String getGewicht_regel() {
		return gewicht_regel;
	}

	public void setGewicht_regel(String gewicht_regel) {
		this.gewicht_regel = gewicht_regel;
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

	public Set<Rasse_Eigenschaft_Mod> getEigenschafts_modifikatoren() {
		return eigenschafts_modifikatoren;
	}

	public void setEigenschafts_modifikatoren(Set<Rasse_Eigenschaft_Mod> eigenschafts_modifikatoren) {
		this.eigenschafts_modifikatoren = eigenschafts_modifikatoren;
	}

	public Set<Rasse_Vorteil> getRasse_vorteile() {
		return rasse_vorteile;
	}

	public void setRasse_vorteile(Set<Rasse_Vorteil> rasse_vorteile) {
		this.rasse_vorteile = rasse_vorteile;
	}

	public Set<Rasse_Nachteil> getRasse_nachteile() {
		return rasse_nachteile;
	}

	public void setRasse_nachteile(Set<Rasse_Nachteil> rasse_nachteile) {
		this.rasse_nachteile = rasse_nachteile;
	}

	public Set<Rasse_Kultur> getRasse_kulturen() {
		return rasse_kulturen;
	}

	public void setRasse_kulturen(Set<Rasse_Kultur> rasse_kulturen) {
		this.rasse_kulturen = rasse_kulturen;
	}

	public Set<Rasse_Talent_Mod> getRasse_talente() {
		return rasse_talente;
	}

	public void setRasse_talente(Set<Rasse_Talent_Mod> rasse_talente) {
		this.rasse_talente = rasse_talente;
	}
}
