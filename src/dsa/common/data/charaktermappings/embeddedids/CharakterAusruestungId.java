package dsa.common.data.charaktermappings.embeddedids;

import javax.persistence.ManyToOne;

import dsa.common.data.Ausruestung;
import dsa.common.data.Charakter;

public class CharakterAusruestungId {
	@ManyToOne
	private Charakter charakter;
	@ManyToOne
	private Ausruestung ausruestung;
	/*--------------------   Constructor Area --------------------*/

	/*--------------------    Function   Area --------------------*/
	//TODO: equals Function
	/*-------------------- Getter/Setter Area --------------------*/
	public Charakter getCharakter() {
		return charakter;
	}
	public void setCharakter(Charakter charakter) {
		this.charakter = charakter;
	}
	public Ausruestung getAusruestung() {
		return ausruestung;
	}
	public void setAusruestung(Ausruestung ausruestung) {
		this.ausruestung = ausruestung;
	}
}
