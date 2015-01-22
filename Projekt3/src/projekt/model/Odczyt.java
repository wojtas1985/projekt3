package projekt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Odczyt")
public class Odczyt implements Serializable{

	private static final long serialVersionUID = 8633312206862823631L;

@Id
@GeneratedValue
@Column(name="odczytId")
private Integer odczytId;

@Column(name="odczytData")
@Temporal(TemporalType.DATE)
private Date odczytData;

@Column(name="okresOd")
@Temporal(TemporalType.DATE)
private Date odczytOkresPoczatek;

@Column(name="okresDo")
@Temporal(TemporalType.DATE)
private Date odczytOkresKoniec;

@ManyToOne
@JoinColumn(name="obiektId", insertable=false, updatable=false)
private Obiekt obiekt;

private Integer obiektId;

@OneToOne(cascade=CascadeType.ALL, mappedBy="odczyt", orphanRemoval=true)
private Cieplo cieplo;

@OneToOne(cascade=CascadeType.ALL, mappedBy="odczyt", orphanRemoval=true)
private Energia energia;

@OneToOne(cascade=CascadeType.ALL, mappedBy="odczyt", orphanRemoval=true)
private Gaz gaz;

@OneToOne(cascade=CascadeType.ALL, mappedBy="odczyt", orphanRemoval=true)
private Woda woda;

public Odczyt(){
	
}

public Odczyt(Date odczytData, Date odczytOkresPoczatek, Date odczytOkresKoniec, Integer obiektId){
	this.odczytData = odczytData;
	this.odczytOkresPoczatek = odczytOkresPoczatek;
	this.odczytOkresKoniec = odczytOkresKoniec;
	this.obiektId = obiektId;
}

public Integer getOdczytId() {
	return odczytId;
}

public void setOdczytId(Integer odczytId) {
	this.odczytId = odczytId;
}

public Date getOdczytData() {
	return odczytData;
}

public void setOdczytData(Date odczytData) {
	this.odczytData = odczytData;
}

public Date getOdczytOkresPoczatek() {
	return odczytOkresPoczatek;
}

public void setOdczytOkresPoczatek(Date odczytOkresPoczatek) {
	this.odczytOkresPoczatek = odczytOkresPoczatek;
}

public Date getOdczytOkresKoniec() {
	return odczytOkresKoniec;
}

public void setOdczytOkresKoniec(Date odczytOkresKoniec) {
	this.odczytOkresKoniec = odczytOkresKoniec;
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
