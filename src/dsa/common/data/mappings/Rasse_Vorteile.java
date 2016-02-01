package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Vorteil;
import dsa.common.data.Rasse;
import dsa.common.data.mappings.ids.Rasse_VorteilID;

@Entity
@Table(name="rasse_vorteil_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.rasse", 
		joinColumns = @JoinColumn(name = "RASSE_ID")),
	@AssociationOverride(name = "pk.vorteil", 
		joinColumns = @JoinColumn(name = "VORTEIL_ID"))})
public class Rasse_Vorteile {
	public static Byte	RASSE_VORTEIL_AUTOMATISCH = 0,
						RASSE_VORTEIL_EMPFOHLEN = 1,
						RASSE_VORTEIL_UNGEEIGNET = 2;
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Rasse_Vorteile() {
		this.pk = new Rasse_VorteilID();
	}
	public Rasse_Vorteile(Rasse r) {
		this.pk = new Rasse_VorteilID();
		this.setRasse(r);
	}
	
	@EmbeddedId
	private Rasse_VorteilID pk;
	
	public Rasse getRasse() {
		return pk.getRasse();
	}
	public void setRasse(Rasse rasse) {
		this.pk.setRasse(rasse);
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
		if(obj instanceof Rasse_Vorteile)
			return pk.equals(((Rasse_Vorteile)obj).pk);
		return false;
	}
}
