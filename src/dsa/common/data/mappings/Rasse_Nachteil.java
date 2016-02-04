package dsa.common.data.mappings;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dsa.common.data.Nachteil;
import dsa.common.data.Rasse;
import dsa.common.data.mappings.ids.Rasse_NachteilID;
import dsa.common.data.wrapper.NameIdWrapper;

@Entity
@Table(name="rasse_nachteil_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.rasse", 
		joinColumns = @JoinColumn(name = "RASSE_ID")),
	@AssociationOverride(name = "pk.nachteil", 
		joinColumns = @JoinColumn(name = "NACHTEIL_ID"))})
public class Rasse_Nachteil {
	public final static byte	RASSE_NACHTEIL_AUTOMATISCH = 0,
								RASSE_NACHTEIL_EMPFOHLEN = 1,
								RASSE_NACHTEIL_UNGEEIGNET = 2;
	public final static String	RASSE_NACHTEIL_AUTOMATISCH_STR = "Automatisch",
								RASSE_NACHTEIL_EMPFOHLEN_STR = "Empfohlen",
								RASSE_NACHTEIL_UNGEEIGNET_STR = "Ungeeignet";
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Rasse_Nachteil() {
		this.pk = new Rasse_NachteilID();
	}
	public Rasse_Nachteil(Rasse r) {
		this.pk = new Rasse_NachteilID();
		this.setRasse(r);
	}
	
	@EmbeddedId
	private Rasse_NachteilID pk;
	
	public Rasse getRasse() {
		return pk.getRasse();
	}
	public void setRasse(Rasse rasse) {
		this.pk.setRasse(rasse);
	}
	public Nachteil getNachteil() {
		return pk.getNachteil();
	}
	public void setNachteil(Nachteil nachteil) {
		this.pk.setNachteil(nachteil);
	}
	public Integer getWert() {
		return wert;
	}
	public void setWert(Integer wert) {
		this.wert = wert;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Byte getTyp() {
		return typ;
	}
	public void setTyp(Byte typ) {
		this.typ = typ;
	}
	
	@Override
	public int hashCode() {
		return pk.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rasse_Nachteil)
			return pk.equals(((Rasse_Nachteil)obj).pk);
		return false;
	}
	public static List<NameIdWrapper> getTypNameIdWrapper() {
		List<NameIdWrapper> retval = new ArrayList<NameIdWrapper>();
		retval.add(new NameIdWrapper(RASSE_NACHTEIL_AUTOMATISCH, RASSE_NACHTEIL_AUTOMATISCH_STR));
		retval.add(new NameIdWrapper(RASSE_NACHTEIL_EMPFOHLEN, RASSE_NACHTEIL_EMPFOHLEN_STR));
		retval.add(new NameIdWrapper(RASSE_NACHTEIL_UNGEEIGNET, RASSE_NACHTEIL_UNGEEIGNET_STR));
		return retval;
	}
}
