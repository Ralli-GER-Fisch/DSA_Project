package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Kultur;
import dsa.common.data.mappings.ids.Kultur_Eigenschaft_ModID;

@Entity
@Table(name="kultur_eigenschaft_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.kultur", 
		joinColumns = @JoinColumn(name = "KULTUR_ID")),
	@AssociationOverride(name = "pk.eigenschaft", 
		joinColumns = @JoinColumn(name = "EIGENSCHAFT_ID"))})
public class Kultur_Eigenschaft_Mod {
	
	private Integer modifikator;
	
	
	public Kultur_Eigenschaft_Mod() {
		this.pk = new Kultur_Eigenschaft_ModID();
	}
	public Kultur_Eigenschaft_Mod(Kultur r) {
		this.pk = new Kultur_Eigenschaft_ModID();
		this.setKultur(r);
	}
	
	@EmbeddedId
	private Kultur_Eigenschaft_ModID pk;
	
	public Kultur getKultur() {
		return pk.getKultur();
	}
	public void setKultur(Kultur kultur) {
		this.pk.setKultur(kultur);
	}
	public Eigenschaft getEigenschaft() {
		return pk.getEigenschaft();
	}
	public void setEigenschaft(Eigenschaft eigenschaft) {
		this.pk.setEigenschaft(eigenschaft);
	}
	public Integer getModifikator() {
		return modifikator;
	}
	public void setModifikator(Integer modifikator) {
		this.modifikator = modifikator;
	}
	
	@Override
	public int hashCode() {
		return pk.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kultur_Eigenschaft_Mod)
			return pk.equals(((Kultur_Eigenschaft_Mod)obj).pk);
		return false;
	}
}
