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

import dsa.common.data.mappings.Rasse_Nachteile;
import dsa.common.data.mappings.Rasse_Vorteile;

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
	private Set<Kultur_Vorteile> kultur_vorteile;
	@OneToMany(mappedBy="pk.rasse",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Kultur_Nachteile> kultur_nachteile;
	@OneToMany(mappedBy="pk.profession",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Kultur_Profession> kultur_professionen;
	@OneToMany(mappedBy="pk.talent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Kultur_Talent> kultur_talente;
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
}
