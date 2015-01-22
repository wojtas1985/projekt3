package projekt.bean;

import java.util.Date;

import projekt.model.ZarzadcaAdres;

public class ZarzadcaBean extends ZarzadcaAdresBean{
	
	private Integer id;
	private String imie;
	private String nazwisko;
	private Date dataUrodzenia;
	private String telefon;
	private String email;
	private Integer obiektId;
	private ZarzadcaAdres zarzadcaAdres;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}
	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ZarzadcaAdres getZarzadcaAdres() {
		return zarzadcaAdres;
	}
	
	public Integer getObiektId() {
		return obiektId;
	}
	public void setObiektId(Integer obiektId) {
		this.obiektId = obiektId;
	}
	public void setZarzadcaAdres(ZarzadcaAdres zarzadcaAdres) {
		this.zarzadcaAdres = zarzadcaAdres;
	}
	
}
