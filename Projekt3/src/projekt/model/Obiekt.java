package projekt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Obiekt")
public class Obiekt implements Serializable{

	private static final long serialVersionUID = -7426263224624027204L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="obiektId")
	private Integer obiektId;
	
	@Column(name="Nazwa")
	private String obiektNazwa;
	
	@Column(name="Powierzchnia")
	private Double obiektPowierzchnia;
	
	@Column(name="Kubatura")
	private Double obiektKubatura;
	
	@Column(name="LiczbaUzytkownikow")
	private Integer obiektLiczbaUzytkownikow;
	
	@Column(name="Calodobowy")
	private Boolean obiektCzyCalodobowy;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="obiekt")
	private ObiektAdres obiektAdres;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="obiekt")
	private ObiektKontakt obiektKontakt;
	
	@OneToMany(mappedBy="obiekt")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Odczyt> odczyty;
	
	@OneToMany(mappedBy="obiekt")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Zarzadca> zarzadcy;
	
	@OneToMany(mappedBy="obiekt")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Internet> wydatkiNaInternet;
	
	@OneToMany(mappedBy="obiekt")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Telefon> wydatkiNaTelefon;

	public Integer getObiektId() {
		return obiektId;
	}

	public void setObiektId(Integer obiektId) {
		this.obiektId = obiektId;
	}

	public String getObiektNazwa() {
		return obiektNazwa;
	}

	public void setObiektNazwa(String obiektNazwa) {
		this.obiektNazwa = obiektNazwa;
	}

	public Double getObiektPowierzchnia() {
		return obiektPowierzchnia;
	}

	public void setObiektPowierzchnia(Double obiektPowierzchnia) {
		this.obiektPowierzchnia = obiektPowierzchnia;
	}

	public Double getObiektKubatura() {
		return obiektKubatura;
	}

	public void setObiektKubatura(Double obiektKubatura) {
		this.obiektKubatura = obiektKubatura;
	}

	public Integer getObiektLiczbaUzytkownikow() {
		return obiektLiczbaUzytkownikow;
	}

	public void setObiektLiczbaUzytkownikow(Integer obiektLiczbaUzytkownikow) {
		this.obiektLiczbaUzytkownikow = obiektLiczbaUzytkownikow;
	}

	public Boolean isObiektCzyCalodobowy() {
		return obiektCzyCalodobowy;
	}

	public void setObiektCzyCalodobowy(Boolean obiektCzyCalodobowy) {
		this.obiektCzyCalodobowy = obiektCzyCalodobowy;
	}

	public ObiektAdres getObiektAdres() {
		return obiektAdres;
	}

	public void setObiektAdres(ObiektAdres obiektAdres) {
		this.obiektAdres = obiektAdres;
	}

	public ObiektKontakt getObiektKontakt() {
		return obiektKontakt;
	}

	public void setObiektKontakt(ObiektKontakt obiektKontakt) {
		this.obiektKontakt = obiektKontakt;
	}

	public Set<Odczyt> getOdczyty() {
		return odczyty;
	}

	public void setOdczyty(Set<Odczyt> odczyty) {
		this.odczyty = odczyty;
	}

	public Set<Internet> getWydatkiNaInternet() {
		return wydatkiNaInternet;
	}

	public void setWydatkiNaInternet(Set<Internet> wydatkiNaInternet) {
		this.wydatkiNaInternet = wydatkiNaInternet;
	}

	public Set<Telefon> getWydatkiNaTelefon() {
		return wydatkiNaTelefon;
	}

	public void setWydatkiNaTelefon(Set<Telefon> wydatkiNaTelefon) {
		this.wydatkiNaTelefon = wydatkiNaTelefon;
	}

	public Set<Zarzadca> getZarzadcy() {
		return zarzadcy;
	}

	public void setZarzadcy(Set<Zarzadca> zarzadcy) {
		this.zarzadcy = zarzadcy;
	}
	
}
