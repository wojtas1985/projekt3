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
@Table(name="Gaz")
public class Gaz {

	@Id
	@GeneratedValue(generator = "gen")
	@Column(name="odczytId", unique=true, nullable = false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="odczyt"))
	private Integer odczytId;
		  
	@OneToOne
	@PrimaryKeyJoinColumn
	private Odczyt odczyt;
	
	@Column(name="gazNM3")
	private Double gazNM3;
	
	@Column(name="gazPLN")
	private Double gazPLN;
	
	public Gaz(){
		
	}
	
	public Gaz(Double gazNM3, Double gazPLN){
		this.gazNM3 = gazNM3;
		this.gazPLN = gazPLN;
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

	public Double getGazNM3() {
		return gazNM3;
	}

	public void setGazNM3(Double gazNM3) {
		this.gazNM3 = gazNM3;
	}

	public Double getGazPLN() {
		return gazPLN;
	}

	public void setGazPLN(Double gazPLN) {
		this.gazPLN = gazPLN;
	}
	
}
