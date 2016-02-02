



package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Vorteil;
import dsa.common.data.Kultur;

@SuppressWarnings("serial")
@Embeddable
public class Kultur_VorteilID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="KULTUR_ID",nullable=false)
	private Kultur kultur;
	@ManyToOne(optional=false)
	@JoinColumn(name="VORTEIL_ID",nullable=false)
	private Vorteil vorteil;

	public Kultur_VorteilID() {
		this.vorteil = new Vorteil();
		this.vorteil.setId(new Long(1));
		this.kultur = new Kultur();
		this.kultur.setId(new Long(1));
		
	}
	public Kultur_VorteilID(Kultur r,Vorteil e) {
		this.kultur = r;
		this.vorteil = e;
	}
	public Vorteil getVorteil() {
		return vorteil;
	}
	public void setVorteil(Vorteil vorteil) {
		this.vorteil = vorteil;
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
		result = prime * result + ((vorteil == null) ? 0 : vorteil.hashCode());
		result = prime * result + ((kultur == null) ? 0 : kultur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kultur_VorteilID)
			return ((Kultur_VorteilID)obj).getKultur().equals(getKultur()) &&
					((Kultur_VorteilID)obj).getVorteil().equals(getVorteil());
		return false;
	}

}
