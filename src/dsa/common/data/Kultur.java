package dsa.common.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import dsa.common.data.mappings.Kultur_Eigenschaft_Mod;
import dsa.common.data.mappings.Kultur_Nachteil;
import dsa.common.data.mappings.Kultur_Profession;
import dsa.common.data.mappings.Kultur_Talent_Mod;
import dsa.common.data.mappings.Kultur_Vorteil;

@Entity
@Table(name="kultur")
public class Kultur {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="KULTUR_ID")
	private Long id;
	private String name;
	private Integer generierungskosten;
	private Integer so_maximum;	
	@Column(name="LE_MOD")
	private Integer lebenspunkte_modifikator;
	@Column(name="AU_MOD")
	private Integer ausdauer_modifikator;
	@Column(name="MR_MOD")
	private Integer magieresistenz_modifikator;
	private Integer sozialstatus_maximum;
	private String beschreibung;
	private Set<Kultur_Eigenschaft_Mod> eigenschafts_modifikatoren;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Kultur_Vorteil> kultur_vorteile;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Kultur_Nachteil> kultur_nachteile;
	@OneToMany(mappedBy="pk.profession",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Kultur_Profession> kultur_professionen;
	@OneToMany(mappedBy="pk.talent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Kultur_Talent_Mod> kultur_talente;
	/*--------------------   Constructor Area --------------------*/
	public Kultur() {
		// TODO Auto-generated constructor stub
	}
	/*--------------------    Function   Area --------------------*/
	
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
	public Integer getGenerierungskosten() {
		return generierungskosten;
	}
	public void setGenerierungskosten(Integer generierungskosten) {
		this.generierungskosten = generierungskosten;
	}
	public Integer getSo_maximum() {
		return so_maximum;
	}
	public void setSo_maximum(Integer so_maximum) {
		this.so_maximum = so_maximum;
	}
	public Integer getLebenspunkte_modifikator() {
		return lebenspunkte_modifikator;
	}
	public void setLebenspunkte_modifikator(Integer lebenspunkte_modifikator) {
		this.lebenspunkte_modifikator = lebenspunkte_modifikator;
	}
	public Integer getAusdauer_modifikator() {
		return ausdauer_modifikator;
	}
	public void setAusdauer_modifikator(Integer ausdauer_modifikator) {
		this.ausdauer_modifikator = ausdauer_modifikator;
	}
	public Integer getMagieresistenz_modifikator() {
		return magieresistenz_modifikator;
	}
	public void setMagieresistenz_modifikator(Integer magieresistenz_modifikator) {
		this.magieresistenz_modifikator = magieresistenz_modifikator;
	}
	public Integer getSozialstatus_maximum() {
		return sozialstatus_maximum;
	}
	public void setSozialstatus_maximum(Integer sozialstatus_maximum) {
		this.sozialstatus_maximum = sozialstatus_maximum;
	}
	public Set<Kultur_Eigenschaft_Mod> getEigenschafts_modifikatoren() {
		return eigenschafts_modifikatoren;
	}
	public void setEigenschafts_modifikatoren(Set<Kultur_Eigenschaft_Mod> eigenschafts_modifikatoren) {
		this.eigenschafts_modifikatoren = eigenschafts_modifikatoren;
	}
	public Set<Kultur_Vorteil> getKultur_vorteile() {
		return kultur_vorteile;
	}
	public void setKultur_vorteile(Set<Kultur_Vorteil> kultur_vorteile) {
		this.kultur_vorteile = kultur_vorteile;
	}
	public Set<Kultur_Nachteil> getKultur_nachteile() {
		return kultur_nachteile;
	}
	public void setKultur_nachteile(Set<Kultur_Nachteil> kultur_nachteile) {
		this.kultur_nachteile = kultur_nachteile;
	}
	public Set<Kultur_Profession> getKultur_professionen() {
		return kultur_professionen;
	}
	public void setKultur_professionen(Set<Kultur_Profession> kultur_professionen) {
		this.kultur_professionen = kultur_professionen;
	}
	public Set<Kultur_Talent_Mod> getKultur_talente() {
		return kultur_talente;
	}
	public void setKultur_talente(Set<Kultur_Talent_Mod> kultur_talente) {
		this.kultur_talente = kultur_talente;
	}
}
