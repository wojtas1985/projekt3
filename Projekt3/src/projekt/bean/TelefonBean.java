package projekt.bean;

import java.util.Date;

public class TelefonBean {
	
	private Integer id;
	private Date dataWystawienia;
	private Date okresPoczatek;
	private Date okresKoniec;
	private Double pLN;
	private Integer obiektId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataWystawienia() {
		return dataWystawienia;
	}
	public void setDataWystawienia(Date dataWystawienia) {
		this.dataWystawienia = dataWystawienia;
	}
	public Date getOkresPoczatek() {
		return okresPoczatek;
	}
	public void setOkresPoczatek(Date okresPoczatek) {
		this.okresPoczatek = okresPoczatek;
	}
	public Date getOkresKoniec() {
		return okresKoniec;
	}
	public void setOkresKoniec(Date okresKoniec) {
		this.okresKoniec = okresKoniec;
	}
	public Double getpLN() {
		return pLN;
	}
	public void setpLN(Double pLN) {
		this.pLN = pLN;
	}
	public Integer getObiektId() {
		return obiektId;
	}
	public void setObiektId(Integer obiektId) {
		this.obiektId = obiektId;
	}

}
