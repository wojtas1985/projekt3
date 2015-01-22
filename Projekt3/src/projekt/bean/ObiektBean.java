package projekt.bean;

public class ObiektBean extends ObiektAdresBean {

	private Integer id;
	private String nazwa;
	private Double powierzchnia;
	private Double kubatura;
	private Integer liczbaUzytkownikow;
	private Boolean czyCalodobowy;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public Double getPowierzchnia() {
		return powierzchnia;
	}
	public void setPowierzchnia(Double powierzchnia) {
		this.powierzchnia = powierzchnia;
	}
	public Double getKubatura() {
		return kubatura;
	}
	public void setKubatura(Double kubatura) {
		this.kubatura = kubatura;
	}
	public Integer getLiczbaUzytkownikow() {
		return liczbaUzytkownikow;
	}
	public void setLiczbaUzytkownikow(Integer liczbaUzytkownikow) {
		this.liczbaUzytkownikow = liczbaUzytkownikow;
	}
	public Boolean getCzyCalodobowy() {
		return czyCalodobowy;
	}
	public void setCzyCalodobowy(Boolean czyCalodobowy) {
		this.czyCalodobowy = czyCalodobowy;
	}
	
}
