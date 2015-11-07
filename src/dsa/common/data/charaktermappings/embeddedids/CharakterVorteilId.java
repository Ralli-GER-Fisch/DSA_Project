package dsa.common.data.charaktermappings.embeddedids;

import javax.persistence.ManyToOne;

import dsa.common.data.Vorteil;
import dsa.common.data.Charakter;

public class CharakterVorteilId {
	@ManyToOne
	private Charakter charakter;
	@ManyToOne
	private Vorteil vorteil;
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
	public Vorteil getVorteil() {
		return vorteil;
	}
	public void setVorteil(Vorteil vorteil) {
		this.vorteil = vorteil;
	}
}
