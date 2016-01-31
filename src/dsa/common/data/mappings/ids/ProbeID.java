package dsa.common.data.mappings.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Talent;

@SuppressWarnings("serial")
@Embeddable
public class ProbeID implements Serializable{
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	@JoinColumn(name="TALENT_ID",nullable=false)
	private Talent talent;
	@ManyToOne(optional=false)
	@JoinColumn(name="EIGENSCHAFT_ID_1",nullable=false)
	private Eigenschaft eigenschaft1;
	@ManyToOne(optional=false)
	@JoinColumn(name="EIGENSCHAFT_ID_2",nullable=false)
	private Eigenschaft eigenschaft2;
	@ManyToOne(optional=false)
	@JoinColumn(name="EIGENSCHAFT_ID_3",nullable=false)
	private Eigenschaft eigenschaft3;

	public ProbeID() {
		this.eigenschaft1 = new Eigenschaft();
		this.eigenschaft1.setId(new Long(1));
		this.eigenschaft2 = new Eigenschaft();
		this.eigenschaft2.setId(new Long(1));
		this.eigenschaft3 = new Eigenschaft();
		this.eigenschaft3.setId(new Long(1));
		this.talent = new Talent();
		this.talent.setId(new Long(1));
		
	}
	public ProbeID(Talent t,Eigenschaft e1, Eigenschaft e2, Eigenschaft e3) {
		this.talent = t;
		this.eigenschaft1 = e1;
		this.eigenschaft2 = e2;
		this.eigenschaft3 = e3;
	}
	public Eigenschaft getEigenschaft1() {
		return eigenschaft1;
	}
	public void setEigenschaft1(Eigenschaft eigenschaft1) {
		this.eigenschaft1 = eigenschaft1;
	}
	public Eigenschaft getEigenschaft2() {
		return eigenschaft2;
	}
	public void setEigenschaft2(Eigenschaft eigenschaft2) {
		this.eigenschaft2 = eigenschaft2;
	}
	public Eigenschaft getEigenschaft3() {
		return eigenschaft3;
	}
	public void setEigenschaft3(Eigenschaft eigenschaft3) {
		this.eigenschaft3 = eigenschaft3;
	}
	public Talent getTalent() {
		return talent;
	}
	public void setTalent(Talent talent) {
		this.talent = talent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eigenschaft1 == null) ? 0 : eigenschaft1.hashCode());
		result = prime * result + ((eigenschaft2 == null) ? 0 : eigenschaft2.hashCode());
		result = prime * result + ((eigenschaft3 == null) ? 0 : eigenschaft3.hashCode());
		result = prime * result + ((talent == null) ? 0 : talent.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ProbeID)
			return ((ProbeID)obj).getTalent().equals(getTalent()) &&
					((ProbeID)obj).getEigenschaft1().equals(getEigenschaft1()) &&
					((ProbeID)obj).getEigenschaft2().equals(getEigenschaft2()) &&
					((ProbeID)obj).getEigenschaft3().equals(getEigenschaft3());
		return false;
	}

}
