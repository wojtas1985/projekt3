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
@Table(name="Energia")
public class Energia {

	@Id
	@GeneratedValue(generator = "gen")
	@Column(name="odczytId", unique=true, nullable = false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="odczyt"))
	private Integer odczytId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Odczyt odczyt;
	
	@Column(name="energiakWh")
	private Double energiaKWH;
	
	@Column(name="energiaPLN")
	private Double energiaPLN;
	
	public Energia(){
		
	}
	
	public Energia(Double energiaKWH, Double energiaPLN){
		this.energiaKWH = energiaKWH;
		this.energiaPLN = energiaPLN;
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

	public Double getEnergiaKWH() {
		return energiaKWH;
	}

	public void setEnergiaKWH(Double energiaKWH) {
		this.energiaKWH = energiaKWH;
	}

	public Double getEnergiaPLN() {
		return energiaPLN;
	}

	public void setEnergiaPLN(Double energiaPLN) {
		this.energiaPLN = energiaPLN;
	}
	
}
