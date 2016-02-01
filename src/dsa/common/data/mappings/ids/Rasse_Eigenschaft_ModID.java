package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Rasse;

@SuppressWarnings("serial")
@Embeddable
public class Rasse_Eigenschaft_ModID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="RASSE_ID",nullable=false)
	private Rasse rasse;
	@ManyToOne(optional=false)
	@JoinColumn(name="EIGENSCHAFT_ID",nullable=false)
	private Eigenschaft eigenschaft;

	public Rasse_Eigenschaft_ModID() {
		this.eigenschaft = new Eigenschaft();
		this.eigenschaft.setId(new Long(1));
		this.rasse = new Rasse();
		this.rasse.setId(new Long(1));
		
	}
	public Rasse_Eigenschaft_ModID(Rasse r,Eigenschaft e) {
		this.rasse = r;
		this.eigenschaft = e;
	}
	public Eigenschaft getEigenschaft() {
		return eigenschaft;
	}
	public void setEigenschaft(Eigenschaft eigenschaft) {
		this.eigenschaft = eigenschaft;
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
		result = prime * result + ((eigenschaft == null) ? 0 : eigenschaft.hashCode());
		result = prime * result + ((rasse == null) ? 0 : rasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rasse_Eigenschaft_ModID)
			return ((Rasse_Eigenschaft_ModID)obj).getRasse().equals(getRasse()) &&
					((Rasse_Eigenschaft_ModID)obj).getEigenschaft().equals(getEigenschaft());
		return false;
	}

}
