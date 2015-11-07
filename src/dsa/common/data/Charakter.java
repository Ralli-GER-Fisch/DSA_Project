package dsa.common.data;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import dsa.common.data.util.adapter.GeschlechtAdapter;
import dsa.common.data.util.enums.Geschlecht;

@XmlRootElement(namespace = "http://ralliGERfisch/DSA_project.com/")
public class Charakter {

	private String name;
	private int	alter;
	@XmlJavaTypeAdapter(GeschlechtAdapter.class)
	private Geschlecht geschlecht;
	private int groesse;
	private int gewicht;
	
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
	
	private int lebenspunkte;
	private int ausdauer;
	private int astralenergie;
	private int karmalenergie;
	private int magieresistenz;
	
	private int beherrschungswert;
	private int artefaktkontrolle;
	private int entrueckung;
	private int geschwindigkeit;
	
	private int abenteuerpunkte;
	private int abenteuerpunkteVerbraucht;
	
	
	@XmlElementWrapper(name = "vorteile")
	@XmlElement(name = "vorteil")
	private List<Vorteil> vorteile;
	
	@XmlElementWrapper(name = "nachteile")
	@XmlElement(name = "nachteil")
	private List<Nachteil> nachteile;
	
	
	private int attackeBasis;
	private int paradeBasis;
	private int fernkampfBasis;
	private int initativeBasis;
	
	
	@XmlElementWrapper(name = "sonderfertigkeiten")
	@XmlElement(name = "sonderfertigkeit")
	private List<Sonderfertigkeit> sonderfertigkeiten;
	
	@XmlElementWrapper(name = "talente")
	@XmlElement(name = "talent")
	private List<Talent> talente;
	
	
	private Geld geld;
	
	@XmlElementWrapper(name = "ausruestung")
	@XmlElementRefs({
		@XmlElementRef(type = Behaelter.class ),
		@XmlElementRef(type = AusruestungsGegenstand.class )
	})
	private List<Ausruestung> ausruestung;

	
	
	
//	@XmlElementRefs(
//			  {
//				    @XmlElementRef( type = Player.class ),
//				    @XmlElementRef( type = Key.class ),
//				  } )
	
	
	
	
	/*-------------------- Getter/Setter Area --------------------*/	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
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

	public int getLebenspunkte() {
		return lebenspunkte;
	}

	public void setLebenspunkte(int lebenspunkte) {
		this.lebenspunkte = lebenspunkte;
	}

	public int getAusdauer() {
		return ausdauer;
	}

	public void setAusdauer(int ausdauer) {
		this.ausdauer = ausdauer;
	}

	public int getAstralenergie() {
		return astralenergie;
	}

	public void setAstralenergie(int astralenergie) {
		this.astralenergie = astralenergie;
	}

	public int getKarmalenergie() {
		return karmalenergie;
	}

	public void setKarmalenergie(int karmalenergie) {
		this.karmalenergie = karmalenergie;
	}

	public int getMagieresistenz() {
		return magieresistenz;
	}

	public void setMagieresistenz(int magieresistenz) {
		this.magieresistenz = magieresistenz;
	}

	public int getBeherrschungswert() {
		return beherrschungswert;
	}

	public void setBeherrschungswert(int beherrschungswert) {
		this.beherrschungswert = beherrschungswert;
	}

	public int getArtefaktkontrolle() {
		return artefaktkontrolle;
	}

	public void setArtefaktkontrolle(int artefaktkontrolle) {
		this.artefaktkontrolle = artefaktkontrolle;
	}

	public int getEntrueckung() {
		return entrueckung;
	}

	public void setEntrueckung(int entrueckung) {
		this.entrueckung = entrueckung;
	}

	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}

	public void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}

	public int getAbenteuerpunkte() {
		return abenteuerpunkte;
	}

	public void setAbenteuerpunkte(int abenteuerpunkte) {
		this.abenteuerpunkte = abenteuerpunkte;
	}

	public int getAbenteuerpunkteVerbraucht() {
		return abenteuerpunkteVerbraucht;
	}

	public void setAbenteuerpunkteVerbraucht(int abenteuerpunkteVerbraucht) {
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

	public int getAttackeBasis() {
		return attackeBasis;
	}

	public void setAttackeBasis(int attackeBasis) {
		this.attackeBasis = attackeBasis;
	}

	public int getParadeBasis() {
		return paradeBasis;
	}

	public void setParadeBasis(int paradeBasis) {
		this.paradeBasis = paradeBasis;
	}

	public int getFernkampfBasis() {
		return fernkampfBasis;
	}

	public void setFernkampfBasis(int fernkampfBasis) {
		this.fernkampfBasis = fernkampfBasis;
	}

	public int getInitativeBasis() {
		return initativeBasis;
	}

	public void setInitativeBasis(int initativeBasis) {
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
