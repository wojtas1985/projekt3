package projekt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Internet")
public class Internet implements Serializable{

	private static final long serialVersionUID = -2529487749857482699L;
	
	@Id
	@GeneratedValue
	@Column(name="internetId")
	private Integer internetId;
	
	@Column(name="internetData")
	@Temporal(TemporalType.DATE)
	private Date internetDataWystawienia;
	
	@Column(name="okresOd")
	@Temporal(TemporalType.DATE)
	private Date internetOkresPoczatek;
	
	@Column(name="okresDo")
	@Temporal(TemporalType.DATE)
	private Date internetOkresKoniec;
	
	@Column(name="KwotaInternet")
	private Double internetPLN;
	
	@ManyToOne
	@JoinColumn(name="obiektId", insertable=false, updatable=false)
	private Obiekt obiekt;
	
	private Integer obiektId;
	
	public Internet(){
		
	}
	
	public Internet(Date internetDataWystawienia, Date internetOkresPoczatek, Date internetOkresKoniec, 
			Double internetPLN, Integer obiektId){
			this.internetDataWystawienia = internetDataWystawienia;
			this.internetOkresPoczatek = internetOkresPoczatek;
			this.internetOkresKoniec = internetOkresKoniec;
			this.internetPLN = internetPLN;
			this.obiektId = obiektId;
	}

	public Integer getInternetId() {
		return internetId;
	}

	public void setInternetId(Integer internetId) {
		this.internetId = internetId;
	}

	public Date getInternetDataWystawienia() {
		return internetDataWystawienia;
	}

	public void setInternetDataWystawienia(Date internetDataWystawienia) {
		this.internetDataWystawienia = internetDataWystawienia;
	}

	public Date getInternetOkresPoczatek() {
		return internetOkresPoczatek;
	}

	public void setInternetOkresPoczatek(Date internetOkresPoczatek) {
		this.internetOkresPoczatek = internetOkresPoczatek;
	}

	public Date getInternetOkresKoniec() {
		return internetOkresKoniec;
	}

	public void setInternetOkresKoniec(Date internetOkresKoniec) {
		this.internetOkresKoniec = internetOkresKoniec;
	}

	public Double getInternetPLN() {
		return internetPLN;
	}

	public void setInternetPLN(Double internetPLN) {
		this.internetPLN = internetPLN;
	}

	public Obiekt getObiekt() {
		return obiekt;
	}

	public void setObiekt(Obiekt obiekt) {
		this.obiekt = obiekt;
	}

	public Integer getObiektId() {
		return obiektId;
	}

	public void setObiektId(Integer obiektId) {
		this.obiektId = obiektId;
	}

}
