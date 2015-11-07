package dsa.common.data;


import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import dsa.common.data.util.adapter.GeschlechtAdapter;
import dsa.common.data.util.enums.Geschlecht;

@Entity
@Table(schema="DSA", name="CHARAKTER")
@XmlRootElement(namespace = "http://ralliGERfisch/DSA_project.com/")
public class Charakter {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
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
	
	
	@XmlElementWrapper(name = "eigenschaften")
	@XmlElement(name = "eigenschaft")
	private List<Eigenschaft> eigenschaften;
	
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
	
	
	@XmlElementWrapper(name = "vorteile")
	@XmlElement(name = "vorteil")
	private List<Vorteil> vorteile;
	
	@XmlElementWrapper(name = "nachteile")
	@XmlElement(name = "nachteil")
	private List<Nachteil> nachteile;
	
	
	private Integer attackeBasis;
	private Integer paradeBasis;
	private Integer fernkampfBasis;
	private Integer initativeBasis;
	
	
	@XmlElementWrapper(name = "sonderfertigkeiten")
	@XmlElement(name = "sonderfertigkeit")
	private List<Sonderfertigkeit> sonderfertigkeiten;
	
	@XmlElementWrapper(name = "talente")
	@XmlElement(name = "talent")
	private List<Talent> talente;
	
	@Embedded
	private Geld geld;
	
	@XmlElementWrapper(name = "ausruestung")
	@XmlElementRefs({
		@XmlElementRef(type = Behaelter.class ),
		@XmlElementRef(type = AusruestungsGegenstand.class )
	})
	private List<Ausruestung> ausruestung;
		
	
	/*--------------------    Function   Area --------------------*/
	public Charakter() {
		// TODO Auto-generated constructor stub
	}

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

	public List<Eigenschaft> getEigenschaften() {
		return eigenschaften;
	}

	public void setEigenschaften(List<Eigenschaft> eigenschaften) {
		this.eigenschaften = eigenschaften;
	}
	
	public void addEigenschaften(Eigenschaft eigenschaft) {
		this.eigenschaften.add(eigenschaft);
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

	public List<Vorteil> getVorteile() {
		return vorteile;
	}

	public void setVorteile(List<Vorteil> vorteile) {
		this.vorteile = vorteile;
	}
	
	public void addVorteil(Vorteil vorteil) {
		this.vorteile.add(vorteil);
	}

	public List<Nachteil> getNachteile() {
		return nachteile;
	}

	public void setNachteile(List<Nachteil> nachteile) {
		this.nachteile = nachteile;
	}
	
	public void addNachteil(Nachteil nachteil) {
		this.nachteile.add(nachteil);
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

	public void addSonderfertigkeit(Sonderfertigkeit sonderfertigkeit) {
		this.sonderfertigkeiten.add(sonderfertigkeit);
	}
	
	public List<Talent> getTalente() {
		return talente;
	}

	public void setTalente(List<Talent> talente) {
		this.talente = talente;
	}
	
	public void addTalente(Talent talent) {
		this.talente.add(talent);
	}

	public Geld getGeld() {
		return geld;
	}

	public void setGeld(Geld geld) {
		this.geld = geld;
	}

	public List<Ausruestung> getAusruestung() {
		return ausruestung;
	}

	public void setAusruestung(List<Ausruestung> ausruestung) {
		this.ausruestung = ausruestung;
	}
	
	public void addAusruestung(Ausruestung ausruestung) {
		this.ausruestung.add(ausruestung);
	}
}
