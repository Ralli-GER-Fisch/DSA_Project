package dsa.common.data;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import dsa.common.data.charaktermappings.CharakterAusruestung;
import dsa.common.data.charaktermappings.CharakterEigenschaft;
import dsa.common.data.charaktermappings.CharakterNachteil;
import dsa.common.data.charaktermappings.CharakterTalent;
import dsa.common.data.charaktermappings.CharakterVorteil;
import dsa.common.data.util.adapter.GeschlechtAdapter;
import dsa.common.data.util.enums.Geschlecht;

@Entity
@Table(schema="DSA", name="CHARAKTER")
@XmlRootElement(namespace = "http://ralliGERfisch/DSA_project.com/")
public class Charakter {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="CHARAKTER_ID")
	private Long id;
	
	@NaturalId
	private String name;
	private Integer	alter;
	@Enumerated(EnumType.STRING)
	@XmlJavaTypeAdapter(GeschlechtAdapter.class)
	private Geschlecht geschlecht;
	private Integer groesse;
	private Integer gewicht;
	
	@XmlElement(name = "augenfarbe")
	private String augenFarbe;
	@XmlElement(name = "haarfarbe")
	private String haarFarbe;
	@XmlElement(name = "hautfarbe")
	private String hautFarbe;
	private Rasse rasse;
	private Kultur kultur;
	private Profession profession;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.charakter")
	@XmlElementWrapper(name = "eigenschaften")
	@XmlElement(name = "eigenschaft")
	private List<CharakterEigenschaft> charakterEigenschaften;
	
	private Integer lebenspunkte;
	private Integer ausdauer;
	private Integer astralenergie;
	private Integer karmalenergie;
	private Integer magieresistenz;
	
	private Integer beherrschungswert;
	private Integer artefaktkontrolle;
	private Integer entrueckung;
	private Integer geschwindigkeit;
	
	private Integer abenteuerpunkte;
	private Integer abenteuerpunkteVerbraucht;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.charakter")
	@XmlElementWrapper(name = "vorteile")
	@XmlElement(name = "vorteil")
	private List<CharakterVorteil> charakterVorteile;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.charakter")
	@XmlElementWrapper(name = "nachteile")
	@XmlElement(name = "nachteil")
	private List<CharakterNachteil> charakterNachteile;
	
	
	private Integer attackeBasis;
	private Integer paradeBasis;
	private Integer fernkampfBasis;
	private Integer initativeBasis;
	
	@OneToMany
	@XmlElementWrapper(name = "sonderfertigkeiten")
	@XmlElement(name = "sonderfertigkeit")
	private List<Sonderfertigkeit> sonderfertigkeiten;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.charakter")
	@XmlElementWrapper(name = "talente")
	@XmlElement(name = "talent")
	private List<CharakterTalent> charakterTalente;
	
	@Embedded
	private Geld geld;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.charakter")
	@XmlElementWrapper(name = "ausruestung")
	@XmlElementRefs({
		@XmlElementRef(type = Behaelter.class ),
		@XmlElementRef(type = AusruestungsGegenstand.class )
	})
	private List<CharakterAusruestung> charakterAusruestung;
		
	
	/*--------------------   Constructor Area --------------------*/
	public Charakter() {
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

	public Integer getAlter() {
		return alter;
	}

	public void setAlter(Integer alter) {
		this.alter = alter;
	}

	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}

	public Integer getGroesse() {
		return groesse;
	}

	public void setGroesse(Integer groesse) {
		this.groesse = groesse;
	}

	public Integer getGewicht() {
		return gewicht;
	}

	public void setGewicht(Integer gewicht) {
		this.gewicht = gewicht;
	}

	public String getAugenFarbe() {
		return augenFarbe;
	}

	public void setAugenFarbe(String augenFarbe) {
		this.augenFarbe = augenFarbe;
	}

	public String getHaarFarbe() {
		return haarFarbe;
	}

	public void setHaarFarbe(String haarFarbe) {
		this.haarFarbe = haarFarbe;
	}

	public String getHautFarbe() {
		return hautFarbe;
	}

	public void setHautFarbe(String hautFarbe) {
		this.hautFarbe = hautFarbe;
	}

	public Rasse getRasse() {
		return rasse;
	}

	public void setRasse(Rasse rasse) {
		this.rasse = rasse;
	}

	public Kultur getKultur() {
		return kultur;
	}

	public void setKultur(Kultur kultur) {
		this.kultur = kultur;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public List<CharakterEigenschaft> getCharakterEigenschaften() {
		return charakterEigenschaften;
	}

	public void setCharakterEigenschaften(List<CharakterEigenschaft> charakterEigenschaften) {
		this.charakterEigenschaften = charakterEigenschaften;
	}

	public Integer getLebenspunkte() {
		return lebenspunkte;
	}

	public void setLebenspunkte(Integer lebenspunkte) {
		this.lebenspunkte = lebenspunkte;
	}

	public Integer getAusdauer() {
		return ausdauer;
	}

	public void setAusdauer(Integer ausdauer) {
		this.ausdauer = ausdauer;
	}

	public Integer getAstralenergie() {
		return astralenergie;
	}

	public void setAstralenergie(Integer astralenergie) {
		this.astralenergie = astralenergie;
	}

	public Integer getKarmalenergie() {
		return karmalenergie;
	}

	public void setKarmalenergie(Integer karmalenergie) {
		this.karmalenergie = karmalenergie;
	}

	public Integer getMagieresistenz() {
		return magieresistenz;
	}

	public void setMagieresistenz(Integer magieresistenz) {
		this.magieresistenz = magieresistenz;
	}

	public Integer getBeherrschungswert() {
		return beherrschungswert;
	}

	public void setBeherrschungswert(Integer beherrschungswert) {
		this.beherrschungswert = beherrschungswert;
	}

	public Integer getArtefaktkontrolle() {
		return artefaktkontrolle;
	}

	public void setArtefaktkontrolle(Integer artefaktkontrolle) {
		this.artefaktkontrolle = artefaktkontrolle;
	}

	public Integer getEntrueckung() {
		return entrueckung;
	}

	public void setEntrueckung(Integer entrueckung) {
		this.entrueckung = entrueckung;
	}

	public Integer getGeschwindigkeit() {
		return geschwindigkeit;
	}

	public void setGeschwindigkeit(Integer geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}

	public Integer getAbenteuerpunkte() {
		return abenteuerpunkte;
	}

	public void setAbenteuerpunkte(Integer abenteuerpunkte) {
		this.abenteuerpunkte = abenteuerpunkte;
	}

	public Integer getAbenteuerpunkteVerbraucht() {
		return abenteuerpunkteVerbraucht;
	}

	public void setAbenteuerpunkteVerbraucht(Integer abenteuerpunkteVerbraucht) {
		this.abenteuerpunkteVerbraucht = abenteuerpunkteVerbraucht;
	}

	public List<CharakterVorteil> getCharakterVorteile() {
		return charakterVorteile;
	}

	public void setCharakterVorteile(List<CharakterVorteil> charakterVorteile) {
		this.charakterVorteile = charakterVorteile;
	}

	public List<CharakterNachteil> getCharakterNachteile() {
		return charakterNachteile;
	}

	public void setCharakterNachteile(List<CharakterNachteil> charakterNachteile) {
		this.charakterNachteile = charakterNachteile;
	}

	public Integer getAttackeBasis() {
		return attackeBasis;
	}

	public void setAttackeBasis(Integer attackeBasis) {
		this.attackeBasis = attackeBasis;
	}

	public Integer getParadeBasis() {
		return paradeBasis;
	}

	public void setParadeBasis(Integer paradeBasis) {
		this.paradeBasis = paradeBasis;
	}

	public Integer getFernkampfBasis() {
		return fernkampfBasis;
	}

	public void setFernkampfBasis(Integer fernkampfBasis) {
		this.fernkampfBasis = fernkampfBasis;
	}

	public Integer getInitativeBasis() {
		return initativeBasis;
	}

	public void setInitativeBasis(Integer initativeBasis) {
		this.initativeBasis = initativeBasis;
	}

	public List<Sonderfertigkeit> getSonderfertigkeiten() {
		return sonderfertigkeiten;
	}

	public void setSonderfertigkeiten(List<Sonderfertigkeit> sonderfertigkeiten) {
		this.sonderfertigkeiten = sonderfertigkeiten;
	}
	
	public List<CharakterTalent> getCharakterTalente() {
		return charakterTalente;
	}

	public void setCharakterTalente(List<CharakterTalent> charakterTalente) {
		this.charakterTalente = charakterTalente;
	}

	public Geld getGeld() {
		return geld;
	}

	public void setGeld(Geld geld) {
		this.geld = geld;
	}
	
	@Transient
	public Integer getDukaten() {
		return getGeld().getDukaten();
	}
	public void setDukaten(Integer dukaten){
		getGeld().setDukaten(dukaten);
	}
	
	@Transient
	public Integer getSilbertaler() {
		return getGeld().getSilbertaler();
	}
	public void setSilbertaler(Integer silbertaler){
		getGeld().setSilbertaler(silbertaler);
	}
	
	@Transient
	public Integer getHeller() {
		return getGeld().getHeller();
	}
	public void setHeller(Integer heller){
		getGeld().setHeller(heller);
	}
	
	@Transient
	public Integer getKreuzer() {
		return getGeld().getKreuzer();
	}
	public void setKreuzer(Integer kreuzer){
		getGeld().setKreuzer(kreuzer);
	}

	public List<CharakterAusruestung> getCharakterAusruestung() {
		return charakterAusruestung;
	}

	public void setCharakterAusruestung(List<CharakterAusruestung> charakterAusruestung) {
		this.charakterAusruestung = charakterAusruestung;
	}
}
