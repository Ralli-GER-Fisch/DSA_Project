package dsa.common.data.charaktermappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import dsa.common.data.Charakter;
import dsa.common.data.Ausruestung;
import dsa.common.data.charaktermappings.embeddedids.CharakterAusruestungId;

@SuppressWarnings("serial")
@Entity
@Table(name="CHARAKTER_AUSRUESTUNG")
@AssociationOverrides({
	@AssociationOverride(name = "pk.charakter", 
		joinColumns = @JoinColumn(name = "CHARAKTER_ID")),
	@AssociationOverride(name = "pk.ausruestung", 
		joinColumns = @JoinColumn(name = "AUSRUESTUNG_ID")) })
public class CharakterAusruestung implements java.io.Serializable{
	@EmbeddedId
	private CharakterAusruestungId pk = new CharakterAusruestungId();
	//TODO: Ort/Position, etc.
	
	/*--------------------   Constructor Area --------------------*/
	public CharakterAusruestung() {
		// TODO Auto-generated constructor stub
	}
	/*--------------------    Function   Area --------------------*/
	
	/*-------------------- Getter/Setter Area --------------------*/
	public CharakterAusruestungId getPk() {
		return pk;
	}
	public void setPk(CharakterAusruestungId pk) {
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
	public Ausruestung getAusruestung(){
		return getPk().getAusruestung();
	}
	public void setAusruestung(Ausruestung ausruestung){
		getPk().setAusruestung(ausruestung);
	}
}
