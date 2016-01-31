package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Talent;
import dsa.common.data.mappings.ids.ProbeID;

@Entity
@Table(name="probe")
@AssociationOverrides({
	@AssociationOverride(name = "pk.talent", 
		joinColumns = @JoinColumn(name = "TALENT_ID")),
	@AssociationOverride(name = "pk.eigenschaft1", 
		joinColumns = @JoinColumn(name = "EIGENSCHAFT_ID_1")),
	@AssociationOverride(name = "pk.eigenschaft2", 
		joinColumns = @JoinColumn(name = "EIGENSCHAFT_ID_2")),
	@AssociationOverride(name = "pk.eigenschaft3", 
		joinColumns = @JoinColumn(name = "EIGENSCHAFT_ID_3"))})
public class Probe{
	public Probe() {
		this.pk = new ProbeID();
	}
	public Probe(Talent t) {
		this.pk = new ProbeID();
		this.setTalent(t);
	}
	
	@EmbeddedId
	private ProbeID pk;
	
	public Talent getTalent() {
		return pk.getTalent();
	}
	public void setTalent(Talent talent) {
		this.pk.setTalent(talent);
	}
	public Eigenschaft getEigenschaft1() {
		return pk.getEigenschaft1();
	}
	public void setEigenschaft1(Eigenschaft eigenschaft1) {
		this.pk.setEigenschaft1(eigenschaft1);
	}
	public Eigenschaft getEigenschaft2() {
		return pk.getEigenschaft2();
	}
	public void setEigenschaft2(Eigenschaft eigenschaft2) {
		this.pk.setEigenschaft2(eigenschaft2);
	}
	public Eigenschaft getEigenschaft3() {
		return pk.getEigenschaft3();
	}
	public void setEigenschaft3(Eigenschaft eigenschaft3) {
		this.pk.setEigenschaft3(eigenschaft3);
	}
	
	@Override
	public int hashCode() {
		return pk.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probe)
			return pk.equals(((Probe)obj).pk);
		return false;
	}
}
