package dsa.common.data;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import dsa.common.data.mappings.Probe;
import dsa.common.data.wrapper.TalentItem;

@Entity
@Table(name="talent")
@Inheritance(strategy=InheritanceType.JOINED)
@DynamicUpdate
@DynamicInsert
public class Talent {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="TALENT_ID")
	private Long id;
	private String name;
	private String kurzinfo;
	private String beschreibung;
	private Long typ;
	private Long gruppe;
	private String spalte;
	@Column(name="EFFEKTIVE_BEHINDERUNG")
	private String eBe;
	@MapsId("talent")
	@OneToMany(mappedBy="pk.talent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Probe> proben;
	
	public final static int		TYP_KAMPF = 0,
								TYP_KOERPERLICH = 1,
								TYP_GESELLSCHAFTLICH = 2,
								TYP_NATUR = 3,
								TYP_WISSEN = 4,
								TYP_HANDWERK = 5,
								TYP_SPRACHE = 6,
								TYP_SCHRIFT = 7,
								TYP_GABE = 8;
	public final static int		GRUPPE_BASIS = 0,
								GRUPPE_SPEZIAL = 1,
								GRUPPE_BERUF = 2;
	public final static String	TYP_KAMPF_STR = "Kampf-Talent",
								TYP_KOERPERLICH_STR= "Körperliches Talent",
								TYP_GESELLSCHAFTLICH_STR = "Gesellschaftliches Talent",
								TYP_NATUR_STR = "Natur-Talent",
								TYP_WISSEN_STR= "Wissenstalent",
								TYP_HANDWERK_STR = "Handwerks-Talent",
								TYP_SPRACHE_STR = "Sprache",
								TYP_SCHRIFT_STR = "Schrift",
								TYP_GABE_STR = "Gabe";
	public final static String	GRUPPE_BASIS_STR = "Basistalent",
								GRUPPE_SPEZIAL_STR = "Spezialtalent",
								GRUPPE_BERUF_STR = "Berufstalent";
	
	/*--------------------   Constructor Area --------------------*/
	public Talent() {
	}
	public Talent(long id) {
		setId(id);
	}
	/*--------------------    Function   Area --------------------*/
	
	/**#################### util ####################**/
	public static String getGruppeStringById(Long id){
		switch(id.intValue()){
			case GRUPPE_BASIS:
				return GRUPPE_BASIS_STR;
			case GRUPPE_BERUF:
				return GRUPPE_BERUF_STR;
			case GRUPPE_SPEZIAL:
				return GRUPPE_SPEZIAL_STR;
			default:
				return null;
		}
	}
	public static int getGruppeIdByString(String name){
		switch(name){
			case GRUPPE_BASIS_STR:
				return GRUPPE_BASIS;
			case GRUPPE_BERUF_STR:
				return GRUPPE_BERUF;
			case GRUPPE_SPEZIAL_STR:
				return GRUPPE_SPEZIAL;
			default:
				return -1;
		}
	}
	public static String getTypStringById(Long id){
		switch(id.intValue()){
			case TYP_GABE:
				return TYP_GABE_STR;
			case TYP_GESELLSCHAFTLICH:
				return TYP_GESELLSCHAFTLICH_STR;
			case TYP_HANDWERK:
				return TYP_HANDWERK_STR;
			case TYP_KAMPF:
				return TYP_KAMPF_STR;
			case TYP_KOERPERLICH:
				return TYP_KOERPERLICH_STR;
			case TYP_NATUR:
				return TYP_NATUR_STR;
			case TYP_SCHRIFT:
				return TYP_SCHRIFT_STR;
			case TYP_SPRACHE:
				return TYP_SPRACHE_STR;
			case TYP_WISSEN:
				return TYP_WISSEN_STR;
			default:
				return null;
		}
	}
	public static int getTypIdByString(String name){
		switch(name){
			case TYP_GABE_STR:
				return TYP_GABE;
			case TYP_GESELLSCHAFTLICH_STR:
				return TYP_GESELLSCHAFTLICH;
			case TYP_HANDWERK_STR:
				return TYP_HANDWERK;
			case TYP_KAMPF_STR:
				return TYP_KAMPF;
			case TYP_KOERPERLICH_STR:
				return TYP_KOERPERLICH;
			case TYP_NATUR_STR:
				return TYP_NATUR;
			case TYP_SCHRIFT_STR:
				return TYP_SCHRIFT;
			case TYP_SPRACHE_STR:
				return TYP_SPRACHE;
			case TYP_WISSEN_STR:
				return TYP_WISSEN;
			default:
				return -1;
		}
	}
	public static List<TalentItem> getTypTalentItemList(){
		return TalentItem.getTypTalentItemList();
	}
	public static List<TalentItem> getGruppeTalentItemList(){
		return TalentItem.getGruppeTalentItemList();
	}
	
	
	/*-------------------- Getter/Setter Area --------------------*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Long getTyp() {
		return typ;
	}
	public void setTyp(Long typ) {
		this.typ = typ;
	}
	public Long getGruppe() {
		return gruppe;
	}
	public void setGruppe(Long gruppe) {
		this.gruppe = gruppe;
	}
	public String getSpalte() {
		return spalte;
	}
	public void setSpalte(String spalte) {
		this.spalte = spalte;
	}
	public String geteBe() {
		return eBe;
	}
	public void seteBe(String eBe) {
		this.eBe = eBe;
	}
	public Set<Probe> getProben() {
		return proben;
	}
	public void setProben(Set<Probe> proben) {
		this.proben = proben;
	}
	public String getKurzinfo() {
		return kurzinfo;
	}
	public void setKurzinfo(String kurzinfo) {
		this.kurzinfo = kurzinfo;
	}
}
