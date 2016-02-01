package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Kultur;
import dsa.common.data.Rasse;

@SuppressWarnings("serial")
@Embeddable
public class Rasse_KulturID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="RASSE_ID",nullable=false)
	private Rasse rasse;
	@ManyToOne(optional=false)
	@JoinColumn(name="KULTUR_ID",nullable=false)
	private Kultur kultur;

	public Rasse_KulturID() {
		this.kultur = new Kultur();
		this.kultur.setId(new Long(1));
		this.rasse = new Rasse();
		this.rasse.setId(new Long(1));
		
	}
	public Rasse_KulturID(Rasse r,Kultur e) {
		this.rasse = r;
		this.kultur = e;
	}
	public Kultur getKultur() {
		return kultur;
	}
	public void setKultur(Kultur kultur) {
		this.kultur = kultur;
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
		result = prime * result + ((kultur == null) ? 0 : kultur.hashCode());
		result = prime * result + ((rasse == null) ? 0 : rasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rasse_KulturID)
			return ((Rasse_KulturID)obj).getRasse().equals(getRasse()) &&
					((Rasse_KulturID)obj).getKultur().equals(getKultur());
		return false;
	}

}
