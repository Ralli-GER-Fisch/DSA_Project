package dsa.common.data;

import dsa.common.data.util.enums.Geschlecht;


public class Charakter {
	private String name;
	private int	alter;
	private Geschlecht geschlecht;
	private int groesse;
	private int gewicht;
	private String augenFarbe;
	private String haarFarbe;
	private String hautFarbe;
	private Rasse rasse;
	private Kultur kultur;
	private Profession profession;
	
	private Attribut attribute[];
	
	private int lebenspunkte;
	private int ausdauer;
	private int astralenergie;
	private int karmalenergie;
	private int magieresistenz;
	
	private int Beherrschungswert;
	private int Artefaktkontrolle;
	private int Entrueckung;
	private int Geschwindigkeit;
	
	private int abenteuerpunkte;
	private int abenteuerpunkteVerbraucht;
	
	private Vorteil vorteile[];
	private Nachteil nachteile[];
	
	private int AttackeBasis;
	private int ParadeBasis;
	private int FernkampfBasis;
	private int InitativeBasis;
	
	private Sonderfertigkeit sonderfertigkeiten[];
	private Talent talente[];
	
	private Geld geld;
	private Ausruestung ausruestung[];
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
	public Attribut[] getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribut[] attribute) {
		this.attribute = attribute;
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
		return Beherrschungswert;
	}
	public void setBeherrschungswert(int beherrschungswert) {
		Beherrschungswert = beherrschungswert;
	}
	public int getArtefaktkontrolle() {
		return Artefaktkontrolle;
	}
	public void setArtefaktkontrolle(int artefaktkontrolle) {
		Artefaktkontrolle = artefaktkontrolle;
	}
	public int getEntrueckung() {
		return Entrueckung;
	}
	public void setEntrueckung(int entrueckung) {
		Entrueckung = entrueckung;
	}
	public int getGeschwindigkeit() {
		return Geschwindigkeit;
	}
	public void setGeschwindigkeit(int geschwindigkeit) {
		Geschwindigkeit = geschwindigkeit;
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
	public Vorteil[] getVorteile() {
		return vorteile;
	}
	public void setVorteile(Vorteil[] vorteile) {
		this.vorteile = vorteile;
	}
	public Nachteil[] getNachteile() {
		return nachteile;
	}
	public void setNachteile(Nachteil[] nachteile) {
		this.nachteile = nachteile;
	}
	public int getAttackeBasis() {
		return AttackeBasis;
	}
	public void setAttackeBasis(int attackeBasis) {
		AttackeBasis = attackeBasis;
	}
	public int getParadeBasis() {
		return ParadeBasis;
	}
	public void setParadeBasis(int paradeBasis) {
		ParadeBasis = paradeBasis;
	}
	public int getFernkampfBasis() {
		return FernkampfBasis;
	}
	public void setFernkampfBasis(int fernkampfBasis) {
		FernkampfBasis = fernkampfBasis;
	}
	public int getInitativeBasis() {
		return InitativeBasis;
	}
	public void setInitativeBasis(int initativeBasis) {
		InitativeBasis = initativeBasis;
	}
	public Sonderfertigkeit[] getSonderfertigkeiten() {
		return sonderfertigkeiten;
	}
	public void setSonderfertigkeiten(Sonderfertigkeit[] sonderfertigkeiten) {
		this.sonderfertigkeiten = sonderfertigkeiten;
	}
	public Talent[] getTalente() {
		return talente;
	}
	public void setTalente(Talent[] talente) {
		this.talente = talente;
	}
	public Geld getGeld() {
		return geld;
	}
	public void setGeld(Geld geld) {
		this.geld = geld;
	}
	public Ausruestung[] getAusruestung() {
		return ausruestung;
	}
	public void setAusruestung(Ausruestung[] ausruestung) {
		this.ausruestung = ausruestung;
	}
	
	
}
