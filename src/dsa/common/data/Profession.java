package dsa.common.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

import dsa.common.data.mappings.Profession_Eigenschaft_Voraussetzung;
import dsa.common.data.mappings.Profession_TalentGruppe_Mod;

@Entity
@Table(name="profession")
public class Profession {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="PROFESSION_ID")
	private Long id;
	private String name;
	private String beschreibung;
	private boolean erstprofession;
	private boolean zeitaufwendig;
	private Integer generierungskosten;
	private Set<Profession_Eigenschaft_Voraussetzung> voraussetzung_eigenschaft;
	private Integer voraussetzung_sozialstatus;
	private Integer ausdauer_modifikator;
	private Set<Profession_TalentGruppe_Mod> talente;
	private Set<Sonderfertigkeit> verbilligteSonderfertigkeiten;
	private Set<Profession_Nachteil> profession_nachteile;
	private Set<Profession_Vorteil> profession_vorteile;
	//private Set<Profession_Ausruestung> ausruestung;
	//private Set<Profession_Ausruestung> besondererBesitz;
	private Set<Profession_Variante> varianten;
	
	/*--------------------   Constructor Area --------------------*/
	public Profession() {
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

	public boolean isErstprofession() {
		return erstprofession;
	}

	public void setErstprofession(boolean erstprofession) {
		this.erstprofession = erstprofession;
	}

	public boolean isZeitaufwendig() {
		return zeitaufwendig;
	}

	public void setZeitaufwendig(boolean zeitaufwendig) {
		this.zeitaufwendig = zeitaufwendig;
	}

	public Integer getGenerierungskosten() {
		return generierungskosten;
	}

	public void setGenerierungskosten(Integer generierungskosten) {
		this.generierungskosten = generierungskosten;
	}

	public Set<Profession_Eigenschaft_Voraussetzung> getVoraussetzung_eigenschaft() {
		return voraussetzung_eigenschaft;
	}

	public void setVoraussetzung_eigenschaft(Set<Profession_Eigenschaft_Voraussetzung> voraussetzung_eigenschaft) {
		this.voraussetzung_eigenschaft = voraussetzung_eigenschaft;
	}

	public Integer getVoraussetzung_sozialstatus() {
		return voraussetzung_sozialstatus;
	}

	public void setVoraussetzung_sozialstatus(Integer voraussetzung_sozialstatus) {
		this.voraussetzung_sozialstatus = voraussetzung_sozialstatus;
	}

	public Integer getAusdauer_modifikator() {
		return ausdauer_modifikator;
	}

	public void setAusdauer_modifikator(Integer ausdauer_modifikator) {
		this.ausdauer_modifikator = ausdauer_modifikator;
	}

	public Set<Profession_TalentGruppe_Mod> getTalente() {
		return talente;
	}

	public void setTalente(Set<Profession_TalentGruppe_Mod> talente) {
		this.talente = talente;
	}

	public Set<Sonderfertigkeit> getVerbilligteSonderfertigkeiten() {
		return verbilligteSonderfertigkeiten;
	}

	public void setVerbilligteSonderfertigkeiten(Set<Sonderfertigkeit> verbilligteSonderfertigkeiten) {
		this.verbilligteSonderfertigkeiten = verbilligteSonderfertigkeiten;
	}

	public Set<Profession_Nachteil_Mod> getProfession_nachteile() {
		return profession_nachteile;
	}

	public void setProfession_nachteile(Set<Profession_Nachteil_Mod> profession_nachteile) {
		this.profession_nachteile = profession_nachteile;
	}

	public Set<Profession_Vorteil_Mod> getProfession_vorteile() {
		return profession_vorteile;
	}

	public void setProfession_vorteile(Set<Profession_Vorteil_Mod> profession_vorteile) {
		this.profession_vorteile = profession_vorteile;
	}

	public Set<Profession_Variante> getVarianten() {
		return varianten;
	}

	public void setVarianten(Set<Profession_Variante> varianten) {
		this.varianten = varianten;
	}
}
