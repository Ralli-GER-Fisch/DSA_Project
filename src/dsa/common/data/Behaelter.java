package dsa.common.data;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Behaelter {
	private String name;
	private int gewicht;
	private Vector<Integer> dimensionen;
	
	@XmlElementWrapper(name = "inhalt")
	@XmlElementRefs({
		@XmlElementRef(type = Behaelter.class),
		@XmlElementRef(type = AusruestungsGegenstand.class)
	})
	private List<Ausruestung> inhalt;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	public Vector<Integer> getDimensionen() {
		return dimensionen;
	}

	public void setDimensionen(Vector<Integer> dimensionen) {
		this.dimensionen = dimensionen;
	}

	public List<Ausruestung> getInhalt() {
		return inhalt;
	}

	public void setInhalt(List<Ausruestung> inhalt) {
		this.inhalt = inhalt;
	}
	
	public void addInhalt(Ausruestung objekt) {
		this.inhalt.add(objekt);
	}
}
