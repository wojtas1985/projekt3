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
@Table(name = "Cieplo")
public class Cieplo{

@Id
@GeneratedValue(generator = "gen")
@Column(name="odczytId", unique=true, nullable = false)
@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="odczyt"))
private Integer odczytId;
	  
@OneToOne
@PrimaryKeyJoinColumn
private Odczyt odczyt;

@Column(name="cieploGJ")
private Double cieploGJ;

@Column(name="cieploPLN")
private Double cieploPLN;

public Cieplo(){
}

public Cieplo(Double cieploGJ, Double cieploPLN){
	this.cieploGJ = cieploGJ;
	this.cieploPLN = cieploPLN;
}

public Integer getOdczytId() {
	return odczytId;
}

public void setOdczytId(Integer odczytId) {
	this.odczytId = odczytId;
}

public Double getCieploGJ() {
	return cieploGJ;
}

public void setCieploGJ(Double cieploGJ) {
	this.cieploGJ = cieploGJ;
}

public Double getCieploPLN() {
	return cieploPLN;
}

public void setCieploPLN(Double cieploPLN) {
	this.cieploPLN = cieploPLN;
}

public Odczyt getOdczyt() {
	return odczyt;
}

public void setOdczyt(Odczyt odczyt) {
	this.odczyt = odczyt;
}


}
