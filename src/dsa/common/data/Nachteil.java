package dsa.common.data;

public class Nachteil {
	private String name;
	private int wert;
	private String beschreibung;
	private Wirkung auswirkung;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWert() {
		return wert;
	}
	public void setWert(int wert) {
		this.wert = wert;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Wirkung getAuswirkung() {
		return auswirkung;
	}
	public void setAuswirkung(Wirkung auswirkung) {
		this.auswirkung = auswirkung;
	}
}
