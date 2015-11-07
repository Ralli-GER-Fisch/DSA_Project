package dsa.common.data.charaktermappings.embeddedids;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import dsa.common.data.Charakter;
import dsa.common.data.Eigenschaft;

@SuppressWarnings("serial")
@Embeddable
public class CharakterEigenschaftId implements java.io.Serializable {
	@ManyToOne
	private Charakter charakter;
	@ManyToOne
	private Eigenschaft eigenschaft;
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
	public Eigenschaft getEigenschaft() {
		return eigenschaft;
	}
	public void setEigenschaft(Eigenschaft eigenschaft) {
		this.eigenschaft = eigenschaft;
	}
}
