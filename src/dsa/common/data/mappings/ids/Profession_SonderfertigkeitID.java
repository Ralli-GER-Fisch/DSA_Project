package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Sonderfertigkeit;
import dsa.common.data.Profession;

@SuppressWarnings("serial")
@Embeddable
public class Profession_SonderfertigkeitID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="PROFESSION_ID",nullable=false)
	private Profession profession;
	@ManyToOne(optional=false)
	@JoinColumn(name="SONDERFERTIGKEIT_ID",nullable=false)
	private Sonderfertigkeit sonderfertigkeit;

	public Profession_SonderfertigkeitID() {
		this.sonderfertigkeit = new Sonderfertigkeit();
		this.sonderfertigkeit.setId(new Long(1));
		this.profession = new Profession();
		this.profession.setId(new Long(1));
		
	}
	public Profession_SonderfertigkeitID(Profession r,Sonderfertigkeit e) {
		this.profession = r;
		this.sonderfertigkeit = e;
	}
	public Sonderfertigkeit getSonderfertigkeit() {
		return sonderfertigkeit;
	}
	public void setSonderfertigkeit(Sonderfertigkeit sonderfertigkeit) {
		this.sonderfertigkeit = sonderfertigkeit;
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
		result = prime * result + ((sonderfertigkeit == null) ? 0 : sonderfertigkeit.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profession_SonderfertigkeitID)
			return ((Profession_SonderfertigkeitID)obj).getProfession().equals(getProfession()) &&
					((Profession_SonderfertigkeitID)obj).getSonderfertigkeit().equals(getSonderfertigkeit());
		return false;
	}

}
