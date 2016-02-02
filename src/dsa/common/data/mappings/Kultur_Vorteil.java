package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Vorteil;
import dsa.common.data.Kultur;
import dsa.common.data.mappings.ids.Kultur_VorteilID;

@Entity
@Table(name="kultur_vorteil_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.kultur", 
		joinColumns = @JoinColumn(name = "KULTUR_ID")),
	@AssociationOverride(name = "pk.vorteil", 
		joinColumns = @JoinColumn(name = "VORTEIL_ID"))})
public class Kultur_Vorteil {
	public static Byte	KULTUR_VORTEIL_AUTOMATISCH = 0,
						KULTUR_VORTEIL_EMPFOHLEN = 1,
						KULTUR_VORTEIL_UNGEEIGNET = 2;
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Kultur_Vorteil() {
		this.pk = new Kultur_VorteilID();
	}
	public Kultur_Vorteil(Kultur r) {
		this.pk = new Kultur_VorteilID();
		this.setKultur(r);
	}
	
	@EmbeddedId
	private Kultur_VorteilID pk;
	
	public Kultur getKultur() {
		return pk.getKultur();
	}
	public void setKultur(Kultur kultur) {
		this.pk.setKultur(kultur);
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
		if(obj instanceof Kultur_Vorteil)
			return pk.equals(((Kultur_Vorteil)obj).pk);
		return false;
	}
}
