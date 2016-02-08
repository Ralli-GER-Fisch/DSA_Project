package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Profession;
import dsa.common.data.mappings.ids.Profession_Eigenschaft_VoraussetzungID;

@Entity
@Table(name="profession_eigenschaft_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.profession", 
		joinColumns = @JoinColumn(name = "PROFESSION_ID")),
	@AssociationOverride(name = "pk.eigenschaft", 
		joinColumns = @JoinColumn(name = "EIGENSCHAFT_ID"))})
public class Profession_Eigenschaft_Voraussetzung {
	
	private Integer modifikator;
	
	
	public Profession_Eigenschaft_Voraussetzung() {
		this.pk = new Profession_Eigenschaft_VoraussetzungID();
	}
	public Profession_Eigenschaft_Voraussetzung(Profession r) {
		this.pk = new Profession_Eigenschaft_VoraussetzungID();
		this.setProfession(r);
	}
	
	@EmbeddedId
	private Profession_Eigenschaft_VoraussetzungID pk;
	
	public Profession getProfession() {
		return pk.getProfession();
	}
	public void setProfession(Profession profession) {
		this.pk.setProfession(profession);
	}
	public Eigenschaft getEigenschaft() {
		return pk.getEigenschaft();
	}
	public void setEigenschaft(Eigenschaft eigenschaft) {
		this.pk.setEigenschaft(eigenschaft);
	}
	public Integer getModifikator() {
		return modifikator;
	}
	public void setModifikator(Integer modifikator) {
		this.modifikator = modifikator;
	}
	
	@Override
	public int hashCode() {
		return pk.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profession_Eigenschaft_Voraussetzung)
			return pk.equals(((Profession_Eigenschaft_Voraussetzung)obj).pk);
		return false;
	}
}
