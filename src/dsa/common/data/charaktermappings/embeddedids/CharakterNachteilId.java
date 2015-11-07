package dsa.common.data.charaktermappings.embeddedids;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import dsa.common.data.Charakter;
import dsa.common.data.Nachteil;

@SuppressWarnings("serial")
@Embeddable
public class CharakterNachteilId implements java.io.Serializable {
	@ManyToOne
	private Charakter charakter;
	@ManyToOne
	private Nachteil nachteil;
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
	public Nachteil getNachteil() {
		return nachteil;
	}
	public void setNachteil(Nachteil nachteil) {
		this.nachteil = nachteil;
	}
}
