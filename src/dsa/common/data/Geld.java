package dsa.common.data;

import javax.persistence.Embeddable;

@Embeddable
public class Geld {
	private Integer dukaten;
	private Integer silbertaler;
	private Integer heller;
	private Integer kreuzer;
	public Integer getDukaten() {
		return dukaten;
	}
	public void setDukaten(Integer dukaten) {
		this.dukaten = dukaten;
	}
	public Integer getSilbertaler() {
		return silbertaler;
	}
	public void setSilbertaler(Integer silbertaler) {
		this.silbertaler = silbertaler;
	}
	public Integer getHeller() {
		return heller;
	}
	public void setHeller(Integer heller) {
		this.heller = heller;
	}
	public Integer getKreuzer() {
		return kreuzer;
	}
	public void setKreuzer(Integer kreuzer) {
		this.kreuzer = kreuzer;
	}
}
