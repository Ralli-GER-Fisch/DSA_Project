package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Vorteil;
import dsa.common.data.Profession;
import dsa.common.data.mappings.ids.Profession_VorteilID;

@Entity
@Table(name="profession_vorteil_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.profession", 
		joinColumns = @JoinColumn(name = "PROFESSION_ID")),
	@AssociationOverride(name = "pk.vorteil", 
		joinColumns = @JoinColumn(name = "VORTEIL_ID"))})
public class Profession_Vorteil {
	public static Byte	PROFESSION_VORTEIL_AUTOMATISCH = 0,
						PROFESSION_VORTEIL_EMPFOHLEN = 1,
						PROFESSION_VORTEIL_UNGEEIGNET = 2;
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Profession_Vorteil() {
		this.pk = new Profession_VorteilID();
	}
	public Profession_Vorteil(Profession r) {
		this.pk = new Profession_VorteilID();
		this.setProfession(r);
	}
	
	@EmbeddedId
	private Profession_VorteilID pk;
	
	public Profession getProfession() {
		return pk.getProfession();
	}
	public void setProfession(Profession profession) {
		this.pk.setProfession(profession);
	}
	public Vorteil getVorteil() {
		return pk.getVorteil();
	}
	public void setVorteil(Vorteil vorteil) {
		this.pk.setVorteil(vorteil);
	}
	public Integer getWert() {
		return wert;
	}
	public void setWert(Integer wert) {
		this.wert = wert;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Byte getTyp() {
		return typ;
	}
	public void setTyp(Byte typ) {
		this.typ = typ;
	}
	
	@Override
	public int hashCode() {
		return pk.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profession_Vorteil)
			return pk.equals(((Profession_Vorteil)obj).pk);
		return false;
	}
}
