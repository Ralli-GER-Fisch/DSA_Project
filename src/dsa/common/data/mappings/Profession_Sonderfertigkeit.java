package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Sonderfertigkeit;
import dsa.common.data.Profession;
import dsa.common.data.mappings.ids.Profession_SonderfertigkeitID;

@Entity
@Table(name="profession_sonderfertigkeit_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.profession", 
		joinColumns = @JoinColumn(name = "PROFESSION_ID")),
	@AssociationOverride(name = "pk.sonderfertigkeit", 
		joinColumns = @JoinColumn(name = "SONDERFERTIGKEIT_ID"))})
public class Profession_Sonderfertigkeit {
	public static Byte	PROFESSION_SONDERFERTIGKEIT_AUTOMATISCH = 0,
						PROFESSION_SONDERFERTIGKEIT_VERBILLIGT = 1;
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Profession_Sonderfertigkeit() {
		this.pk = new Profession_SonderfertigkeitID();
	}
	public Profession_Sonderfertigkeit(Profession r) {
		this.pk = new Profession_SonderfertigkeitID();
		this.setProfession(r);
	}
	
	@EmbeddedId
	private Profession_SonderfertigkeitID pk;
	
	public Profession getProfession() {
		return pk.getProfession();
	}
	public void setProfession(Profession profession) {
		this.pk.setProfession(profession);
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
		if(obj instanceof Profession_Sonderfertigkeit)
			return pk.equals(((Profession_Sonderfertigkeit)obj).pk);
		return false;
	}
}
