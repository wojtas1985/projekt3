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
@Table(name="Telefon")
public class Telefon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5018889722715348176L;

	@Id
	@GeneratedValue
	@Column(name="telefonId")
	private Integer telefonId;
	
	@Column(name="telefonData")
	@Temporal(TemporalType.DATE)
	private Date telefonDataWystawienia;
	
	@Column(name="okresOd")
	@Temporal(TemporalType.DATE)
	private Date telefonOkresPoczatek;
	
	@Column(name="okresDo")
	@Temporal(TemporalType.DATE)
	private Date telefonOkresKoniec;
	
	@Column(name="KwotaTelefon")
	private Double telefonPLN;
	
	@ManyToOne
	@JoinColumn(name="obiektId", insertable=false, updatable=false)
	private Obiekt obiekt;
	
	private Integer obiektId;
	
	public Telefon(){
		
	}
	
	public Telefon(Date telefonDataWystawienia, Date telefonOkresPoczatek, Date telefonOkresKoniec, 
			Double telefonPLN, Integer obiektId){
			this.telefonDataWystawienia = telefonDataWystawienia;
			this.telefonOkresPoczatek = telefonOkresPoczatek;
			this.telefonOkresKoniec = telefonOkresKoniec;
			this.telefonPLN = telefonPLN;
			this.obiektId = obiektId;
	}

	public Integer getTelefonId() {
		return telefonId;
	}

	public void setTelefonId(Integer telefonId) {
		this.telefonId = telefonId;
	}

	public Date getTelefonDataWystawienia() {
		return telefonDataWystawienia;
	}

	public void setTelefonDataWystawienia(Date telefonDataWystawienia) {
		this.telefonDataWystawienia = telefonDataWystawienia;
	}

	public Date getTelefonOkresPoczatek() {
		return telefonOkresPoczatek;
	}

	public void setTelefonOkresPoczatek(Date telefonOkresPoczatek) {
		this.telefonOkresPoczatek = telefonOkresPoczatek;
	}

	public Date getTelefonOkresKoniec() {
		return telefonOkresKoniec;
	}

	public void setTelefonOkresKoniec(Date telefonOkresKoniec) {
		this.telefonOkresKoniec = telefonOkresKoniec;
	}

	public Double getTelefonPLN() {
		return telefonPLN;
	}

	public void setTelefonPLN(Double telefonPLN) {
		this.telefonPLN = telefonPLN;
	}

	public Integer getObiektId() {
		return obiektId;
	}

	public void setObiektId(Integer obiektId) {
		this.obiektId = obiektId;
	}

	public Obiekt getObiekt() {
		return obiekt;
	}

	public void setObiekt(Obiekt obiekt) {
		this.obiekt = obiekt;
	}

}
