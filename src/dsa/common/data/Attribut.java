package dsa.common.data;

import dsa.common.data.util.enums.AttributTyp;

public class Attribut {
	private AttributTyp typ;
	private byte wert;
	public AttributTyp getTyp() {
		return typ;
	}
	public void setTyp(AttributTyp typ) {
		this.typ = typ;
	}
	public byte getWert() {
		return wert;
	}
	public void setWert(byte wert) {
		this.wert = wert;
	}
}
