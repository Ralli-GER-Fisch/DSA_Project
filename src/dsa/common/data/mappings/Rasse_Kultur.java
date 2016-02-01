package dsa.common.data.mappings;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Kultur;
import dsa.common.data.Rasse;
import dsa.common.data.mappings.ids.Rasse_KulturID;

@Entity
@Table(name="rasse_kultur")
@AssociationOverrides({
	@AssociationOverride(name = "pk.rasse", 
		joinColumns = @JoinColumn(name = "RASSE_ID")),
	@AssociationOverride(name = "pk.kultur", 
		joinColumns = @JoinColumn(name = "KULTUR_ID"))})
public class Rasse_Kultur {
	public static Byte	RASSE_KULTUR_UEBLICH = 0,
						RASSE_KULTUR_MOEGLICH = 1;
	private Byte typ;
	private String information;
	
	
	public Rasse_Kultur() {
		this.pk = new Rasse_KulturID();
	}
	public Rasse_Kultur(Rasse r) {
		this.pk = new Rasse_KulturID();
		this.setRasse(r);
	}
	
	@EmbeddedId
	private Rasse_KulturID pk;
	
	public Rasse getRasse() {
		return pk.getRasse();
	}
	public void setRasse(Rasse rasse) {
		this.pk.setRasse(rasse);
	}
	public Kultur getKultur() {
		return pk.getKultur();
	}
	public void setKultur(Kultur kultur) {
		this.pk.setKultur(kultur);
	}
	public Byte getTyp() {
		return typ;
	}
	public void setTyp(Byte typ) {
		this.typ = typ;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public int hashCode() {
		return pk.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rasse_Kultur)
			return pk.equals(((Rasse_Kultur)obj).pk);
		return false;
	}
}
