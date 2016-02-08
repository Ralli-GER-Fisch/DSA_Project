package dsa.common.data.mappings;

import javax.persistence.Embeddable;

@Embeddable
public class Profession_Sozialstatus_Voraussetzung {
	private Integer min_SO;
	private Integer max_SO;
	
	
	public Integer getMin_SO() {
		return min_SO;
	}
	public void setMin_SO(Integer min_SO) {
		this.min_SO = min_SO;
	}
	public Integer getMax_SO() {
		return max_SO;
	}
	public void setMax_SO(Integer max_SO) {
		this.max_SO = max_SO;
	}
}
