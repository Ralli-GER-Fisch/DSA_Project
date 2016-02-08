package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Profession;

@SuppressWarnings("serial")
@Embeddable
public class Profession_Eigenschaft_VoraussetzungID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="PROFESSION_ID",nullable=false)
	private Profession profession;
	@ManyToOne(optional=false)
	@JoinColumn(name="EIGENSCHAFT_ID",nullable=false)
	private Eigenschaft eigenschaft;

	public Profession_Eigenschaft_VoraussetzungID() {
		this.eigenschaft = new Eigenschaft();
		this.eigenschaft.setId(new Long(1));
		this.profession = new Profession();
		this.profession.setId(new Long(1));
		
	}
	public Profession_Eigenschaft_VoraussetzungID(Profession r,Eigenschaft e) {
		this.profession = r;
		this.eigenschaft = e;
	}
	public Eigenschaft getEigenschaft() {
		return eigenschaft;
	}
	public void setEigenschaft(Eigenschaft eigenschaft) {
		this.eigenschaft = eigenschaft;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eigenschaft == null) ? 0 : eigenschaft.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profession_Eigenschaft_VoraussetzungID)
			return ((Profession_Eigenschaft_VoraussetzungID)obj).getProfession().equals(getProfession()) &&
					((Profession_Eigenschaft_VoraussetzungID)obj).getEigenschaft().equals(getEigenschaft());
		return false;
	}

}
