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
import dsa.common.data.Eigenschaft;
import dsa.common.data.charaktermappings.embeddedids.CharakterEigenschaftId;

@SuppressWarnings("serial")
@Entity
@Table(name="CHARAKTER_EIGENSCHAFT")
@AssociationOverrides({
	@AssociationOverride(name = "pk.charakter", 
		joinColumns = @JoinColumn(name = "CHARAKTER_ID")),
	@AssociationOverride(name = "pk.eigenschaft", 
		joinColumns = @JoinColumn(name = "EIGENSCHAFT_ID")) })
public class CharakterEigenschaft implements java.io.Serializable {
	@EmbeddedId
	private CharakterEigenschaftId pk = new CharakterEigenschaftId();
	@Column(name="WERT", nullable = false)
	private Byte wert;
	
	/*--------------------   Constructor Area --------------------*/
	public CharakterEigenschaft() {
		// TODO Auto-generated constructor stub
	}
	/*--------------------    Function   Area --------------------*/
	
	/*-------------------- Getter/Setter Area --------------------*/
	public CharakterEigenschaftId getPk() {
		return pk;
	}
	public void setPk(CharakterEigenschaftId pk) {
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
	public Eigenschaft getEigenschaft(){
		return getPk().getEigenschaft();
	}
	public void setEigenschaft(Eigenschaft eigenschaft){
		getPk().setEigenschaft(eigenschaft);
	}
	public Byte getWert() {
		return wert;
	}
	public void setWert(Byte wert) {
		this.wert = wert;
	}
}
