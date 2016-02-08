package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Sonderfertigkeit;
import dsa.common.data.Kultur;

@SuppressWarnings("serial")
@Embeddable
public class Kultur_SonderfertigkeitID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="KULTUR_ID",nullable=false)
	private Kultur kultur;
	@ManyToOne(optional=false)
	@JoinColumn(name="SONDERFERTIGKEIT_ID",nullable=false)
	private Sonderfertigkeit sonderfertigkeit;

	public Kultur_SonderfertigkeitID() {
		this.sonderfertigkeit = new Sonderfertigkeit();
		this.sonderfertigkeit.setId(new Long(1));
		this.kultur = new Kultur();
		this.kultur.setId(new Long(1));
		
	}
	public Kultur_SonderfertigkeitID(Kultur r,Sonderfertigkeit e) {
		this.kultur = r;
		this.sonderfertigkeit = e;
	}
	public Sonderfertigkeit getSonderfertigkeit() {
		return sonderfertigkeit;
	}
	public void setSonderfertigkeit(Sonderfertigkeit sonderfertigkeit) {
		this.sonderfertigkeit = sonderfertigkeit;
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
		result = prime * result + ((sonderfertigkeit == null) ? 0 : sonderfertigkeit.hashCode());
		result = prime * result + ((kultur == null) ? 0 : kultur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kultur_SonderfertigkeitID)
			return ((Kultur_SonderfertigkeitID)obj).getKultur().equals(getKultur()) &&
					((Kultur_SonderfertigkeitID)obj).getSonderfertigkeit().equals(getSonderfertigkeit());
		return false;
	}

}
