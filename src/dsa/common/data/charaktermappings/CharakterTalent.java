package dsa.common.data.charaktermappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import dsa.common.data.Charakter;
import dsa.common.data.Talent;
import dsa.common.data.charaktermappings.embeddedids.CharakterTalentId;


@SuppressWarnings("serial")
@Entity
@Table(name = "CHARAKTER_TALENT")
@AssociationOverrides({
		@AssociationOverride(name = "pk.charakter", 
			joinColumns = @JoinColumn(name = "CHARAKTER_ID")),
		@AssociationOverride(name = "pk.talent", 
			joinColumns = @JoinColumn(name = "TALENT_ID")) })
public abstract class CharakterTalent implements java.io.Serializable{
	@EmbeddedId
	private CharakterTalentId pk = new CharakterTalentId();
	@Column(name="TALENTWERT", nullable = false)
	private Byte talentwert;
	// TODO: Typ etc.
	/*--------------------   Constructor Area --------------------*/

	/*--------------------    Function   Area --------------------*/
	
	/*-------------------- Getter/Setter Area --------------------*/
	public CharakterTalentId getPk() {
		return pk;
	}
	public void setPk(CharakterTalentId pk) {
		this.pk = pk;
	}
	@Transient
	public Charakter getCharakter(){
		return getPk().getCharakter();
	}
	public void setCharakter(Charakter charakter){
		getPk().setCharakter(charakter);
	}
	@Transient
	public Talent getTalent(){
		return getPk().getTalent();
	}
	public void setTalent(Talent talent){
		getPk().setTalent(talent);
	}
	public Byte getTalentwert() {
		return talentwert;
	}
	public void setTalentwert(Byte talentwert) {
		this.talentwert = talentwert;
	}
}
