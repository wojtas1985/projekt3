package projekt.bean;

import java.util.Date;

import projekt.model.Cieplo;
import projekt.model.Energia;
import projekt.model.Gaz;
import projekt.model.Woda;

public class OdczytBean {

	private Integer id;
	private Date data;
	private Date okresPoczatek;
	private Date okresKoniec;
	private Integer obiektId;
	private Cieplo cieplo;
	private Energia energia;
	private Gaz gaz;
	private Woda woda;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	
	public Integer getObiektId() {
		return obiektId;
	}
	public void setObiektId(Integer obiektId) {
		this.obiektId = obiektId;
	}
	
	public Cieplo getCieplo() {
		return cieplo;
	}
	public void setCieplo(Cieplo cieplo) {
		this.cieplo = cieplo;
	}
	
	public Energia getEnergia() {
		return energia;
	}
	public void setEnergia(Energia energia) {
		this.energia = energia;
	}
	
	public Gaz getGaz() {
		return gaz;
	}
	public void setGaz(Gaz gaz) {
		this.gaz = gaz;
	}
	
	public Woda getWoda() {
		return woda;
	}
	public void setWoda(Woda woda) {
		this.woda = woda;
	}
	
}
