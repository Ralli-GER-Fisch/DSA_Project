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
import dsa.common.data.Nachteil;
import dsa.common.data.charaktermappings.embeddedids.CharakterNachteilId;

@SuppressWarnings("serial")
@Entity
@Table(name="CHARAKTER_NACHTEIL")
@AssociationOverrides({
	@AssociationOverride(name = "pk.charakter", 
		joinColumns = @JoinColumn(name = "CHARAKTER_ID")),
	@AssociationOverride(name = "pk.nachteil", 
		joinColumns = @JoinColumn(name = "NACHTEIL_ID")) })
public class CharakterNachteil implements java.io.Serializable{
	@EmbeddedId
	private CharakterNachteilId pk = new CharakterNachteilId();
	@Column(name="WERT", nullable = false)
	private Byte wert;
	
	/*--------------------   Constructor Area --------------------*/
	public CharakterNachteil() {
		// TODO Auto-generated constructor stub
	}
	/*--------------------    Function   Area --------------------*/
	
	/*-------------------- Getter/Setter Area --------------------*/
	public CharakterNachteilId getPk() {
		return pk;
	}
	public void setPk(CharakterNachteilId pk) {
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
	public Nachteil getNachteil(){
		return getPk().getNachteil();
	}
	public void setNachteil(Nachteil nachteil){
		getPk().setNachteil(nachteil);
	}
	public Byte getWert() {
		return wert;
	}
	public void setWert(Byte wert) {
		this.wert = wert;
	}
}
