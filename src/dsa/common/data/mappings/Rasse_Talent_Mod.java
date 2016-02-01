package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Talent;
import dsa.common.data.Rasse;
import dsa.common.data.mappings.ids.Rasse_Talent_ModID;

@Entity
@Table(name="rasse_talent_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.rasse", 
		joinColumns = @JoinColumn(name = "RASSE_ID")),
	@AssociationOverride(name = "pk.talent", 
		joinColumns = @JoinColumn(name = "TALENT_ID"))})
public class Rasse_Talent_Mod {
	
	private Integer modifikator;
	
	
	public Rasse_Talent_Mod() {
		this.pk = new Rasse_Talent_ModID();
	}
	public Rasse_Talent_Mod(Rasse r) {
		this.pk = new Rasse_Talent_ModID();
		this.setRasse(r);
	}
	
	@EmbeddedId
	private Rasse_Talent_ModID pk;
	
	public Rasse getRasse() {
		return pk.getRasse();
	}
	public void setRasse(Rasse rasse) {
		this.pk.setRasse(rasse);
	}
	public Talent getTalent() {
		return pk.getTalent();
	}
	public void setTalent(Talent talent) {
		this.pk.setTalent(talent);
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
		if(obj instanceof Rasse_Talent_Mod)
			return pk.equals(((Rasse_Talent_Mod)obj).pk);
		return false;
	}
}
