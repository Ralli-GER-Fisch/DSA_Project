



package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Vorteil;
import dsa.common.data.Profession;

@SuppressWarnings("serial")
@Embeddable
public class Profession_VorteilID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="PROFESSION_ID",nullable=false)
	private Profession profession;
	@ManyToOne(optional=false)
	@JoinColumn(name="VORTEIL_ID",nullable=false)
	private Vorteil vorteil;

	public Profession_VorteilID() {
		this.vorteil = new Vorteil();
		this.vorteil.setId(new Long(1));
		this.profession = new Profession();
		this.profession.setId(new Long(1));
		
	}
	public Profession_VorteilID(Profession r,Vorteil e) {
		this.profession = r;
		this.vorteil = e;
	}
	public Vorteil getVorteil() {
		return vorteil;
	}
	public void setVorteil(Vorteil vorteil) {
		this.vorteil = vorteil;
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
		result = prime * result + ((vorteil == null) ? 0 : vorteil.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Profession_VorteilID)
			return ((Profession_VorteilID)obj).getProfession().equals(getProfession()) &&
					((Profession_VorteilID)obj).getVorteil().equals(getVorteil());
		return false;
	}

}
