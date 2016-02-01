package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Vorteil;
import dsa.common.data.Rasse;

@SuppressWarnings("serial")
@Embeddable
public class Rasse_VorteilID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="RASSE_ID",nullable=false)
	private Rasse rasse;
	@ManyToOne(optional=false)
	@JoinColumn(name="VORTEIL_ID",nullable=false)
	private Vorteil vorteil;

	public Rasse_VorteilID() {
		this.vorteil = new Vorteil();
		this.vorteil.setId(new Long(1));
		this.rasse = new Rasse();
		this.rasse.setId(new Long(1));
		
	}
	public Rasse_VorteilID(Rasse r,Vorteil e) {
		this.rasse = r;
		this.vorteil = e;
	}
	public Vorteil getVorteil() {
		return vorteil;
	}
	public void setVorteil(Vorteil vorteil) {
		this.vorteil = vorteil;
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
		result = prime * result + ((vorteil == null) ? 0 : vorteil.hashCode());
		result = prime * result + ((rasse == null) ? 0 : rasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rasse_VorteilID)
			return ((Rasse_VorteilID)obj).getRasse().equals(getRasse()) &&
					((Rasse_VorteilID)obj).getVorteil().equals(getVorteil());
		return false;
	}

}
