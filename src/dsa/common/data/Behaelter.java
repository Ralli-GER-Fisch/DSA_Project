package dsa.common.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="AUSRUESTUNGBEHAELTER")
@PrimaryKeyJoinColumn(name="AUSRUESTUNG_ID")
public class Behaelter extends Ausruestung{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="AUSRUESTUNGBEHAELTER_ID")
	private Long id;
	//Muss anders organisiert werden um Behälter nur einfach zu definieren, aber das Mapping für viele Charakter offen zu lassen.
	private Integer gewicht;
	//private Vector<Integer> dimensionen;
	
	@XmlElementWrapper(name = "inhalt")
	@XmlElementRefs({
		@XmlElementRef(type = Behaelter.class),
		@XmlElementRef(type = AusruestungsGegenstand.class)
	})
	private List<Ausruestung> inhalt;
	/*--------------------   Constructor Area --------------------*/
	public Behaelter() {
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

	public Integer getGewicht() {
		return gewicht;
	}

	public void setGewicht(Integer gewicht) {
		this.gewicht = gewicht;
	}

	public List<Ausruestung> getInhalt() {
		return inhalt;
	}

	public void setInhalt(List<Ausruestung> inhalt) {
		this.inhalt = inhalt;
	}

}
