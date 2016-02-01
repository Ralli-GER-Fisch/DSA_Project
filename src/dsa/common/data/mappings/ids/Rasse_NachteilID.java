package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Nachteil;
import dsa.common.data.Rasse;

@SuppressWarnings("serial")
@Embeddable
public class Rasse_NachteilID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="RASSE_ID",nullable=false)
	private Rasse rasse;
	@ManyToOne(optional=false)
	@JoinColumn(name="NACHTEIL_ID",nullable=false)
	private Nachteil nachteil;

	public Rasse_NachteilID() {
		this.nachteil = new Nachteil();
		this.nachteil.setId(new Long(1));
		this.rasse = new Rasse();
		this.rasse.setId(new Long(1));
		
	}
	public Rasse_NachteilID(Rasse r,Nachteil e) {
		this.rasse = r;
		this.nachteil = e;
	}
	public Nachteil getNachteil() {
		return nachteil;
	}
	public void setNachteil(Nachteil nachteil) {
		this.nachteil = nachteil;
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
		result = prime * result + ((nachteil == null) ? 0 : nachteil.hashCode());
		result = prime * result + ((rasse == null) ? 0 : rasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rasse_NachteilID)
			return ((Rasse_NachteilID)obj).getRasse().equals(getRasse()) &&
					((Rasse_NachteilID)obj).getNachteil().equals(getNachteil());
		return false;
	}

}
