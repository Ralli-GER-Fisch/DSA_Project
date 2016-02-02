package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Kultur;

@SuppressWarnings("serial")
@Embeddable
public class Kultur_Eigenschaft_ModID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="KULTUR_ID",nullable=false)
	private Kultur kultur;
	@ManyToOne(optional=false)
	@JoinColumn(name="EIGENSCHAFT_ID",nullable=false)
	private Eigenschaft eigenschaft;

	public Kultur_Eigenschaft_ModID() {
		this.eigenschaft = new Eigenschaft();
		this.eigenschaft.setId(new Long(1));
		this.kultur = new Kultur();
		this.kultur.setId(new Long(1));
		
	}
	public Kultur_Eigenschaft_ModID(Kultur r,Eigenschaft e) {
		this.kultur = r;
		this.eigenschaft = e;
	}
	public Eigenschaft getEigenschaft() {
		return eigenschaft;
	}
	public void setEigenschaft(Eigenschaft eigenschaft) {
		this.eigenschaft = eigenschaft;
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
		result = prime * result + ((eigenschaft == null) ? 0 : eigenschaft.hashCode());
		result = prime * result + ((kultur == null) ? 0 : kultur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kultur_Eigenschaft_ModID)
			return ((Kultur_Eigenschaft_ModID)obj).getKultur().equals(getKultur()) &&
					((Kultur_Eigenschaft_ModID)obj).getEigenschaft().equals(getEigenschaft());
		return false;
	}

}
