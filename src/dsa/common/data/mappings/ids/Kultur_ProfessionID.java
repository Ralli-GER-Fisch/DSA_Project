package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Profession;
import dsa.common.data.Kultur;

@SuppressWarnings("serial")
@Embeddable
public class Kultur_ProfessionID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="KULTUR_ID",nullable=false)
	private Kultur kultur;
	@ManyToOne(optional=false)
	@JoinColumn(name="PROFESSION_ID",nullable=false)
	private Profession profession;

	public Kultur_ProfessionID() {
		this.profession = new Profession();
		this.profession.setId(new Long(1));
		this.kultur = new Kultur();
		this.kultur.setId(new Long(1));
		
	}
	public Kultur_ProfessionID(Kultur r,Profession e) {
		this.kultur = r;
		this.profession = e;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public Kultur getKultur() {
		return kultur;
	}
	public void setKultur(Kultur kultur) {
		this.kultur = kultur;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		result = prime * result + ((kultur == null) ? 0 : kultur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kultur_ProfessionID)
			return ((Kultur_ProfessionID)obj).getKultur().equals(getKultur()) &&
					((Kultur_ProfessionID)obj).getProfession().equals(getProfession());
		return false;
	}

}
