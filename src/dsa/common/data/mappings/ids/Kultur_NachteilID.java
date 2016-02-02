package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Nachteil;
import dsa.common.data.Kultur;

@SuppressWarnings("serial")
@Embeddable
public class Kultur_NachteilID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="KULTUR_ID",nullable=false)
	private Kultur kultur;
	@ManyToOne(optional=false)
	@JoinColumn(name="NACHTEIL_ID",nullable=false)
	private Nachteil nachteil;

	public Kultur_NachteilID() {
		this.nachteil = new Nachteil();
		this.nachteil.setId(new Long(1));
		this.kultur = new Kultur();
		this.kultur.setId(new Long(1));
		
	}
	public Kultur_NachteilID(Kultur r,Nachteil e) {
		this.kultur = r;
		this.nachteil = e;
	}
	public Nachteil getNachteil() {
		return nachteil;
	}
	public void setNachteil(Nachteil nachteil) {
		this.nachteil = nachteil;
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
		result = prime * result + ((nachteil == null) ? 0 : nachteil.hashCode());
		result = prime * result + ((kultur == null) ? 0 : kultur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kultur_NachteilID)
			return ((Kultur_NachteilID)obj).getKultur().equals(getKultur()) &&
					((Kultur_NachteilID)obj).getNachteil().equals(getNachteil());
		return false;
	}

}
