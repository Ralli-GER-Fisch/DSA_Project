package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Nachteil;
import dsa.common.data.Profession;
import dsa.common.data.mappings.ids.Profession_NachteilID;

@Entity
@Table(name="profession_nachteil_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.profession", 
		joinColumns = @JoinColumn(name = "PROFESSION_ID")),
	@AssociationOverride(name = "pk.nachteil", 
		joinColumns = @JoinColumn(name = "NACHTEIL_ID"))})
public class Profession_Nachteil {
	public static Byte	PROFESSION_NACHTEIL_AUTOMATISCH = 0,
						PROFESSION_NACHTEIL_EMPFOHLEN = 1,
						PROFESSION_NACHTEIL_UNGEEIGNET = 2;
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Profession_Nachteil() {
		this.pk = new Profession_NachteilID();
	}
	public Profession_Nachteil(Profession r) {
		this.pk = new Profession_NachteilID();
		this.setProfession(r);
	}
	
	@EmbeddedId
	private Profession_NachteilID pk;
	
	public Profession getProfession() {
		return pk.getProfession();
	}
	public void setProfession(Profession profession) {
		this.pk.setProfession(profession);
	}
	public Nachteil getNachteil() {
		return pk.getNachteil();
	}
	public void setNachteil(Nachteil nachteil) {
		this.pk.setNachteil(nachteil);
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
		if(obj instanceof Profession_Nachteil)
			return pk.equals(((Profession_Nachteil)obj).pk);
		return false;
	}
}
