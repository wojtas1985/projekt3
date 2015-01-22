package projekt.bean;

public class ObiektAdresBean extends ObiektKontaktBean{
	
	private Integer id;
	private String miejscowosc;
	private String kodPocztowy;
	private String ulica;
	private String numerDomu;
	
	public String getMiejscowosc() {
		return miejscowosc;
	}
	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}
	public String getKodPocztowy() {
		return kodPocztowy;
	}
	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getNumerDomu() {
		return numerDomu;
	}
	public void setNumerDomu(String numerDomu) {
		this.numerDomu = numerDomu;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
