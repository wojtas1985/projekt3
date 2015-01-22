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
@Table(name="Woda")
public class Woda {

	@Id
	@GeneratedValue(generator = "gen")
	@Column(name="odczytId", unique=true, nullable = false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="odczyt"))
	private Integer odczytId;
		  
	@OneToOne
	@PrimaryKeyJoinColumn
	private Odczyt odczyt;
	
	@Column(name="wodaM3")
	private Double wodaM3;
	
	@Column(name="wodaPLN")
	private Double wodaPLN;
	
	public Woda(){
		
	}
	
	public Woda(Double wodaM3, Double wodaPLN){
		this.wodaM3 = wodaM3;
		this.wodaPLN = wodaPLN;
	}

	public Integer getOdczytId() {
		return odczytId;
	}

	public void setOdczytId(Integer odczytId) {
		this.odczytId = odczytId;
	}

	public Odczyt getOdczyt() {
		return odczyt;
	}

	public void setOdczyt(Odczyt odczyt) {
		this.odczyt = odczyt;
	}

	public Double getWodaM3() {
		return wodaM3;
	}

	public void setWodaM3(Double wodaM3) {
		this.wodaM3 = wodaM3;
	}

	public Double getWodaPLN() {
		return wodaPLN;
	}

	public void setWodaPLN(Double wodaPLN) {
		this.wodaPLN = wodaPLN;
	}
	
}
