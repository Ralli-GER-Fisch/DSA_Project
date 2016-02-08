package dsa.common.data.mappings;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import dsa.common.data.Kultur;
import dsa.common.data.Talent;
/** Oder-Verknüpfte Talente oder einzelne Talente*/
@Entity
@Table(name="kultur_talentgruppe_mod")
public class Kultur_TalentGruppe_Mod {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="TALENTGRUPPE_ID")
	private Long id;
	private Kultur kultur;
	@ManyToOne
	private Set<Talent> talentAlternativen;
	private Integer modifikator;
	
	public Kultur_TalentGruppe_Mod() {
	}
	public Kultur_TalentGruppe_Mod(long id) {
		setId(id);
	}
	public Kultur_TalentGruppe_Mod(Kultur kultur) {
		setKultur(kultur);
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Kultur getKultur() {
		return kultur;
	}
	public void setKultur(Kultur kultur) {
		this.kultur = kultur;
	}
	public Set<Talent> getTalentAlternativen() {
		return talentAlternativen;
	}
	public void setTalentAlternativen(Set<Talent> talentAlternativen) {
		this.talentAlternativen = talentAlternativen;
	}
	public Integer getModifikator() {
		return modifikator;
	}
	public void setModifikator(Integer modifikator) {
		this.modifikator = modifikator;
	}
}
