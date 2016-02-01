package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Talent;
import dsa.common.data.Rasse;

@SuppressWarnings("serial")
@Embeddable
public class Rasse_Talent_ModID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="RASSE_ID",nullable=false)
	private Rasse rasse;
	@ManyToOne(optional=false)
	@JoinColumn(name="TALENT_ID",nullable=false)
	private Talent talent;

	public Rasse_Talent_ModID() {
		this.talent = new Talent();
		this.talent.setId(new Long(1));
		this.rasse = new Rasse();
		this.rasse.setId(new Long(1));
		
	}
	public Rasse_Talent_ModID(Rasse r,Talent e) {
		this.rasse = r;
		this.talent = e;
	}
	public Talent getTalent() {
		return talent;
	}
	public void setTalent(Talent talent) {
		this.talent = talent;
	}
	public Rasse getRasse() {
		return rasse;
	}
	public void setRasse(Rasse rasse) {
		this.rasse = rasse;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((talent == null) ? 0 : talent.hashCode());
		result = prime * result + ((rasse == null) ? 0 : rasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rasse_Talent_ModID)
			return ((Rasse_Talent_ModID)obj).getRasse().equals(getRasse()) &&
					((Rasse_Talent_ModID)obj).getTalent().equals(getTalent());
		return false;
	}

}
