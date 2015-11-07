package dsa.common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="AUSRUESTUNGSGEGENSTAND")
@PrimaryKeyJoinColumn(name="AUSRUESTUNG_ID")
public class AusruestungsGegenstand extends Ausruestung{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="AUSRUESTUNGSGEGENSTAND_ID")
	private Long id;
	
	private Integer gewicht;
	//private Vector<Integer> dimensionen;
	/*--------------------   Constructor Area --------------------*/
	public AusruestungsGegenstand() {
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
}
