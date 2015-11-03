package dsa.common.data;

public abstract class Talent {
	private String name;
	private byte talentwert;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getTalentwert() {
		return talentwert;
	}
	public void setTalentwert(byte talentwert) {
		this.talentwert = talentwert;
	}
}
