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
@Table(name = "ZarzadcaAdres")
public class ZarzadcaAdres {
	
	@Id
	@GeneratedValue(generator = "gen")
	@Column(name="zarzadcaId", unique=true, nullable = false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="zarzadca"))
	private Integer zarzadcaId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Zarzadca zarzadca;
	
	@Column(name="Miejscowosc")
	private String zarzadcaMiejscowosc;
	
	@Column(name="KodPocztowy")
	private String zarzadcaKodPocztowy;
	
	@Column(name="Ulica")
	private String zarzadcaUlica;
	
	@Column(name="NumerDomu")
	private String zarzadcaNumerDomu;
	
	public ZarzadcaAdres(){
		
	}
	
	public ZarzadcaAdres(String zarzadcaMiejscowosc, String zarzadcaKodPocztowy, String zarzadcaUlica,
			String zarzadcaNumerDomu){
		this.zarzadcaMiejscowosc = zarzadcaMiejscowosc;
		this.zarzadcaKodPocztowy = zarzadcaKodPocztowy;
		this.zarzadcaUlica = zarzadcaUlica;
		this.zarzadcaNumerDomu = zarzadcaNumerDomu;
	}

	public Integer getZarzadcaId() {
		return zarzadcaId;
	}

	public void setZarzadcaId(Integer zarzadcaId) {
		this.zarzadcaId = zarzadcaId;
	}

	public Zarzadca getZarzadca() {
		return zarzadca;
	}

	public void setZarzadca(Zarzadca zarzadca) {
		this.zarzadca = zarzadca;
	}

	public String getZarzadcaMiejscowosc() {
		return zarzadcaMiejscowosc;
	}

	public void setZarzadcaMiejscowosc(String zarzadcaMiejscowosc) {
		this.zarzadcaMiejscowosc = zarzadcaMiejscowosc;
	}

	public String getZarzadcaKodPocztowy() {
		return zarzadcaKodPocztowy;
	}

	public void setZarzadcaKodPocztowy(String zarzadcaKodPocztowy) {
		this.zarzadcaKodPocztowy = zarzadcaKodPocztowy;
	}

	public String getZarzadcaUlica() {
		return zarzadcaUlica;
	}

	public void setZarzadcaUlica(String zarzadcaUlica) {
		this.zarzadcaUlica = zarzadcaUlica;
	}

	public String getZarzadcaNumerDomu() {
		return zarzadcaNumerDomu;
	}

	public void setZarzadcaNumerDomu(String zarzadcaNumerDomu) {
		this.zarzadcaNumerDomu = zarzadcaNumerDomu;
	}
	

}
