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
import dsa.common.data.Vorteil;
import dsa.common.data.charaktermappings.embeddedids.CharakterVorteilId;

@SuppressWarnings("serial")
@Entity
@Table(name="charakter_vorteil")
@AssociationOverrides({
	@AssociationOverride(name = "pk.charakter", 
		joinColumns = @JoinColumn(name = "CHARAKTER_ID")),
	@AssociationOverride(name = "pk.vorteil", 
		joinColumns = @JoinColumn(name = "VORTEIL_ID")) })
public class CharakterVorteil implements java.io.Serializable{
	@EmbeddedId
	private CharakterVorteilId pk = new CharakterVorteilId();
	@Column(name="WERT", nullable = false)
	private Byte wert;
	
	/*--------------------   Constructor Area --------------------*/
	public CharakterVorteil() {
		// TODO Auto-generated constructor stub
	}
	/*--------------------    Function   Area --------------------*/
	
	/*-------------------- Getter/Setter Area --------------------*/
	public CharakterVorteilId getPk() {
		return pk;
	}
	public void setPk(CharakterVorteilId pk) {
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
	public Vorteil getVorteil(){
		return getPk().getVorteil();
	}
	public void setVorteil(Vorteil vorteil){
		getPk().setVorteil(vorteil);
	}
	public Byte getWert() {
		return wert;
	}
	public void setWert(Byte wert) {
		this.wert = wert;
	}
}
