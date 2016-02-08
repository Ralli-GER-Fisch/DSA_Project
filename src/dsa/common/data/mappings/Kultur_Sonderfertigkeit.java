package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Sonderfertigkeit;
import dsa.common.data.Kultur;
import dsa.common.data.mappings.ids.Kultur_SonderfertigkeitID;

@Entity
@Table(name="kultur_sonderfertigkeit_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.kultur", 
		joinColumns = @JoinColumn(name = "KULTUR_ID")),
	@AssociationOverride(name = "pk.sonderfertigkeit", 
		joinColumns = @JoinColumn(name = "SONDERFERTIGKEIT_ID"))})
public class Kultur_Sonderfertigkeit {
	public static Byte	KULTUR_SONDERFERTIGKEIT_AUTOMATISCH = 0,
						KULTUR_SONDERFERTIGKEIT_VERBILLIGT = 1,
						KULTUR_SONDERFERTIGKEIT_HALBEKOSTEN = 2;
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Kultur_Sonderfertigkeit() {
		this.pk = new Kultur_SonderfertigkeitID();
	}
	public Kultur_Sonderfertigkeit(Kultur r) {
		this.pk = new Kultur_SonderfertigkeitID();
		this.setKultur(r);
	}
	
	@EmbeddedId
	private Kultur_SonderfertigkeitID pk;
	
	public Kultur getKultur() {
		return pk.getKultur();
	}
	public void setKultur(Kultur kultur) {
		this.pk.setKultur(kultur);
	}
	public Sonderfertigkeit getSonderfertigkeit() {
		return pk.getSonderfertigkeit();
	}
	public void setSonderfertigkeit(Sonderfertigkeit sonderfertigkeit) {
		this.pk.setSonderfertigkeit(sonderfertigkeit);
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
		if(obj instanceof Kultur_Sonderfertigkeit)
			return pk.equals(((Kultur_Sonderfertigkeit)obj).pk);
		return false;
	}
}
