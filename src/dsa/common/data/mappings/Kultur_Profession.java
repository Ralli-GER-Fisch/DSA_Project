package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Profession;
import dsa.common.data.Kultur;
import dsa.common.data.mappings.ids.Kultur_ProfessionID;

@Entity
@Table(name="kultur_profession_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.kultur", 
		joinColumns = @JoinColumn(name = "KULTUR_ID")),
	@AssociationOverride(name = "pk.profession", 
		joinColumns = @JoinColumn(name = "PROFESSION_ID"))})
public class Kultur_Profession {
	public final static byte	KULTUR_PROFESSION_AUTOMATISCH = 0,
								KULTUR_PROFESSION_EMPFOHLEN = 1,
								KULTUR_PROFESSION_UNGEEIGNET = 2;
	public final static String	KULTUR_PROFESSION_AUTOMATISCH_STR = "automatisch",
								KULTUR_PROFESSION_EMPFOHLEN_STR = "empfohlen",
								KULTUR_PROFESSION_UNGEEIGNET_STR = "ungeeignet";
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Kultur_Profession() {
		this.pk = new Kultur_ProfessionID();
	}
	public Kultur_Profession(Kultur r) {
		this.pk = new Kultur_ProfessionID();
		this.setKultur(r);
	}
	
	@EmbeddedId
	private Kultur_ProfessionID pk;
	
	public Kultur getKultur() {
		return pk.getKultur();
	}
	public void setKultur(Kultur kultur) {
		this.pk.setKultur(kultur);
	}
	public Profession getProfession() {
		return pk.getProfession();
	}
	public void setProfession(Profession profession) {
		this.pk.setProfession(profession);
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
		if(obj instanceof Kultur_Profession)
			return pk.equals(((Kultur_Profession)obj).pk);
		return false;
	}
}
