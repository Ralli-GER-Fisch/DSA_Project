package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Talent;
import dsa.common.data.Kultur;
import dsa.common.data.mappings.ids.Kultur_Talent_ModID;

@Entity
@Table(name="kultur_talent_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.kultur", 
		joinColumns = @JoinColumn(name = "KULTUR_ID")),
	@AssociationOverride(name = "pk.talent", 
		joinColumns = @JoinColumn(name = "TALENT_ID"))})
public class Kultur_Talent_Mod {
	
	private Integer modifikator;
	
	
	public Kultur_Talent_Mod() {
		this.pk = new Kultur_Talent_ModID();
	}
	public Kultur_Talent_Mod(Kultur r) {
		this.pk = new Kultur_Talent_ModID();
		this.setKultur(r);
	}
	
	@EmbeddedId
	private Kultur_Talent_ModID pk;
	
	public Kultur getKultur() {
		return pk.getKultur();
	}
	public void setKultur(Kultur kultur) {
		this.pk.setKultur(kultur);
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
		if(obj instanceof Kultur_Talent_Mod)
			return pk.equals(((Kultur_Talent_Mod)obj).pk);
		return false;
	}
}
