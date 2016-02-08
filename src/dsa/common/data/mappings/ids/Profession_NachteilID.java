package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Nachteil;
import dsa.common.data.Profession;

@SuppressWarnings("serial")
@Embeddable
public class Profession_NachteilID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="PROFESSION_ID",nullable=false)
	private Profession profession;
	@ManyToOne(optional=false)
	@JoinColumn(name="NACHTEIL_ID",nullable=false)
	private Nachteil nachteil;

	public Profession_NachteilID() {
		this.nachteil = new Nachteil();
		this.nachteil.setId(new Long(1));
		this.profession = new Profession();
		this.profession.setId(new Long(1));
		
	}
	public Profession_NachteilID(Profession r,Nachteil e) {
		this.profession = r;
		this.nachteil = e;
	}
	public Nachteil getNachteil() {
		return nachteil;
	}
	public void setNachteil(Nachteil nachteil) {
		this.nachteil = nachteil;
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
		result = prime * result + ((nachteil == null) ? 0 : nachteil.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profession_NachteilID)
			return ((Profession_NachteilID)obj).getProfession().equals(getProfession()) &&
					((Profession_NachteilID)obj).getNachteil().equals(getNachteil());
		return false;
	}

}
