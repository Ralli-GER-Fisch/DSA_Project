package dsa.common.data.charaktermappings.embeddedids;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import dsa.common.data.Talent;
import dsa.common.data.Charakter;

@SuppressWarnings("serial")
@Embeddable
public class CharakterTalentId implements java.io.Serializable {
	@ManyToOne
	private Charakter charakter;
	@ManyToOne
	private Talent talent;
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
	public Talent getTalent() {
		return talent;
	}
	public void setTalent(Talent talent) {
		this.talent = talent;
	}
}
