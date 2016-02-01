package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Rasse;
import dsa.common.data.mappings.ids.Rasse_Eigenschaft_ModID;

@Entity
@Table(name="rasse_eigenschaft_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.rasse", 
		joinColumns = @JoinColumn(name = "RASSE_ID")),
	@AssociationOverride(name = "pk.eigenschaft", 
		joinColumns = @JoinColumn(name = "EIGENSCHAFT_ID"))})
public class Rasse_Eigenschaft_Mod {
	
	private Integer modifikator;
	
	
	public Rasse_Eigenschaft_Mod() {
		this.pk = new Rasse_Eigenschaft_ModID();
	}
	public Rasse_Eigenschaft_Mod(Rasse r) {
		this.pk = new Rasse_Eigenschaft_ModID();
		this.setRasse(r);
	}
	
	@EmbeddedId
	private Rasse_Eigenschaft_ModID pk;
	
	public Rasse getRasse() {
		return pk.getRasse();
	}
	public void setRasse(Rasse rasse) {
		this.pk.setRasse(rasse);
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
		if(obj instanceof Rasse_Eigenschaft_Mod)
			return pk.equals(((Rasse_Eigenschaft_Mod)obj).pk);
		return false;
	}
}
