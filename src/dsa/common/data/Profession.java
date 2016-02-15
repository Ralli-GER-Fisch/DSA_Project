package dsa.common.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import dsa.common.data.mappings.Profession_Eigenschaft_Voraussetzung;
import dsa.common.data.mappings.Profession_Nachteil;
import dsa.common.data.mappings.Profession_Sonderfertigkeit;
import dsa.common.data.mappings.Profession_Sozialstatus_Voraussetzung;
import dsa.common.data.mappings.Profession_TalentGruppe_Mod;
import dsa.common.data.mappings.Profession_Vorteil;

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
	//private byte typ; //TODO: Einzelne Typen klassifizieren
	private Integer generierungskosten;
	private Set<Profession_Eigenschaft_Voraussetzung> voraussetzung_eigenschaft;
	@Embedded
	private Profession_Sozialstatus_Voraussetzung voraussetzung_sozialstatus;
	private Integer ausdauer_modifikator;
	private Set<Profession_TalentGruppe_Mod> talente;
	private Set<Profession_Sonderfertigkeit> profession_sonderfertigkeiten;
	private Set<Profession_Nachteil> profession_nachteile;
	private Set<Profession_Vorteil> profession_vorteile;
	//private Set<Profession_Ausruestung> ausruestung;
	//private Set<Profession_Ausruestung> besondererBesitz;
	@ManyToOne(optional=true)
	private Profession varianteVon;
	
	/*--------------------   Constructor Area --------------------*/
	public Profession() {
	}
	public Profession(long id) {
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

	public Profession_Sozialstatus_Voraussetzung getVoraussetzung_sozialstatus() {
		return voraussetzung_sozialstatus;
	}

	public void setVoraussetzung_sozialstatus(Profession_Sozialstatus_Voraussetzung voraussetzung_sozialstatus) {
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

	public Set<Profession_Nachteil> getProfession_nachteile() {
		return profession_nachteile;
	}

	public void setProfession_nachteile(Set<Profession_Nachteil> profession_nachteile) {
		this.profession_nachteile = profession_nachteile;
	}

	public Set<Profession_Vorteil> getProfession_vorteile() {
		return profession_vorteile;
	}

	public void setProfession_vorteile(Set<Profession_Vorteil> profession_vorteile) {
		this.profession_vorteile = profession_vorteile;
	}
	@Transient
	public Integer getMin_SO() {
		return getVoraussetzung_sozialstatus().getMin_SO();
	}
	public void setMin_SO(Integer min_SO) {
		this.getVoraussetzung_sozialstatus().setMin_SO(min_SO);
	}
	@Transient
	public Integer getMax_SO() {
		return getVoraussetzung_sozialstatus().getMax_SO();
	}
	public void setMax_SO(Integer max_SO) {
		this.getVoraussetzung_sozialstatus().setMax_SO(max_SO);
	}
	public Profession getVarianteVon() {
		return varianteVon;
	}
	public void setVarianteVon(Profession varianteVon) {
		this.varianteVon = varianteVon;
	}
	public Set<Profession_Sonderfertigkeit> getProfession_sonderfertigkeiten() {
		return profession_sonderfertigkeiten;
	}
	public void setProfession_sonderfertigkeiten(Set<Profession_Sonderfertigkeit> profession_sonderfertigkeiten) {
		this.profession_sonderfertigkeiten = profession_sonderfertigkeiten;
	}
}
