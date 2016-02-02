package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Talent;
import dsa.common.data.Kultur;

@SuppressWarnings("serial")
@Embeddable
public class Kultur_Talent_ModID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="KULTUR_ID",nullable=false)
	private Kultur kultur;
	@ManyToOne(optional=false)
	@JoinColumn(name="TALENT_ID",nullable=false)
	private Talent talent;

	public Kultur_Talent_ModID() {
		this.talent = new Talent();
		this.talent.setId(new Long(1));
		this.kultur = new Kultur();
		this.kultur.setId(new Long(1));
		
	}
	public Kultur_Talent_ModID(Kultur r,Talent e) {
		this.kultur = r;
		this.talent = e;
	}
	public Talent getTalent() {
		return talent;
	}
	public void setTalent(Talent talent) {
		this.talent = talent;
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
		result = prime * result + ((talent == null) ? 0 : talent.hashCode());
		result = prime * result + ((kultur == null) ? 0 : kultur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kultur_Talent_ModID)
			return ((Kultur_Talent_ModID)obj).getKultur().equals(getKultur()) &&
					((Kultur_Talent_ModID)obj).getTalent().equals(getTalent());
		return false;
	}

}
