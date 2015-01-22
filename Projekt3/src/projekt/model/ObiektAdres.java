package projekt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ObiektAdres")
public class ObiektAdres {

	@Id
	@GeneratedValue(generator = "gen")
	@Column(name="obiektId", unique=true, nullable = false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="obiekt"))
	private Integer obiektId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Obiekt obiekt;
	
	@Column(name="Miejscowosc")
	private String obiektMiejscowosc;
	
	@Column(name="KodPocztowy")
	private String obiektKodPocztowy;
	
	@Column(name="Ulica")
	private String obiektUlica;
	
	@Column(name="NumerDomu")
	private String obiektNumerDomu;
	
	public ObiektAdres(){
		
	}
	
	public ObiektAdres(String obiektMiejscowosc, String obiektKodPocztowy, String obiektUlica,
			String obiektNumerDomu){
		this.obiektMiejscowosc = obiektMiejscowosc;
		this.obiektKodPocztowy = obiektKodPocztowy;
		this.obiektUlica = obiektUlica;
		this.obiektNumerDomu = obiektNumerDomu;
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

	public String getObiektMiejscowosc() {
		return obiektMiejscowosc;
	}

	public void setObiektMiejscowosc(String obiektMiejscowosc) {
		this.obiektMiejscowosc = obiektMiejscowosc;
	}

	public String getObiektKodPocztowy() {
		return obiektKodPocztowy;
	}

	public void setObiektKodPocztowy(String obiektKodPocztowy) {
		this.obiektKodPocztowy = obiektKodPocztowy;
	}

	public String getObiektUlica() {
		return obiektUlica;
	}

	public void setObiektUlica(String obiektUlica) {
		this.obiektUlica = obiektUlica;
	}

	public String getObiektNumerDomu() {
		return obiektNumerDomu;
	}

	public void setObiektNumerDomu(String obiektNumerDomu) {
		this.obiektNumerDomu = obiektNumerDomu;
	}
	
}
