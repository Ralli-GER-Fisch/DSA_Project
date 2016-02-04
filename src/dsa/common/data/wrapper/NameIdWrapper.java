package dsa.common.data.wrapper;

public class NameIdWrapper {
	private Number id;
	private String name;
	public NameIdWrapper() {
	}
	public NameIdWrapper(Number id, String name) {
		this.id = id;
		this.name = name;
	}
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
}
