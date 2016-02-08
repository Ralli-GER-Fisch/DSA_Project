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
import dsa.common.data.Kultur;
import dsa.common.data.mappings.ids.Kultur_NachteilID;
import dsa.common.data.wrapper.NameIdWrapper;

@Entity
@Table(name="kultur_nachteil_mod")
@AssociationOverrides({
	@AssociationOverride(name = "pk.kultur", 
		joinColumns = @JoinColumn(name = "KULTUR_ID")),
	@AssociationOverride(name = "pk.nachteil", 
		joinColumns = @JoinColumn(name = "NACHTEIL_ID"))})
public class Kultur_Nachteil {
	public final static byte	KULTUR_NACHTEIL_AUTOMATISCH = 0,
								KULTUR_NACHTEIL_EMPFOHLEN = 1,
								KULTUR_NACHTEIL_UNGEEIGNET = 2;
	public final static String	KULTUR_NACHTEIL_AUTOMATISCH_STR = "Automatisch",
								KULTUR_NACHTEIL_EMPFOHLEN_STR = "Empfohlen",
								KULTUR_NACHTEIL_UNGEEIGNET_STR = "Ungeeignet";
	private Integer wert;
	private String information;
	private Byte typ;
	
	public Kultur_Nachteil() {
		this.pk = new Kultur_NachteilID();
	}
	public Kultur_Nachteil(Kultur r) {
		this.pk = new Kultur_NachteilID();
		this.setKultur(r);
	}
	
	@EmbeddedId
	private Kultur_NachteilID pk;
	
	public Kultur getKultur() {
		return pk.getKultur();
	}
	public void setKultur(Kultur kultur) {
		this.pk.setKultur(kultur);
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
		if(obj instanceof Kultur_Nachteil)
			return pk.equals(((Kultur_Nachteil)obj).pk);
		return false;
	}
	public static List<NameIdWrapper> getTypNameIdWrapper() {
		List<NameIdWrapper> retval = new ArrayList<NameIdWrapper>();
		retval.add(new NameIdWrapper(KULTUR_NACHTEIL_AUTOMATISCH, KULTUR_NACHTEIL_AUTOMATISCH_STR));
		retval.add(new NameIdWrapper(KULTUR_NACHTEIL_EMPFOHLEN, KULTUR_NACHTEIL_EMPFOHLEN_STR));
		retval.add(new NameIdWrapper(KULTUR_NACHTEIL_UNGEEIGNET, KULTUR_NACHTEIL_UNGEEIGNET_STR));
		return retval;
	}
}
