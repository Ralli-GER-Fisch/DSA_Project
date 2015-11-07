package dsa.common.data;

import java.util.Vector;

public class AusruestungsGegenstand {
	private String name;
	private int gewicht;
	private Vector<Integer> dimensionen;
	
	
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
}
