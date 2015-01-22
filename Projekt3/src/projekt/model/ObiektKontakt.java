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
@Table(name="ObiektKontakt")
public class ObiektKontakt {

	@Id
	@GeneratedValue(generator = "gen")
	@Column(name="obiektId", unique=true, nullable = false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="obiekt"))
	private Integer obiektId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Obiekt obiekt;
	
	@Column(name="Telefon")
	private String obiektTelefon;
	
	@Column(name="Fax")
	private String obiektFax;
	
	@Column(name="Email")
	private String obiektEmail;
	
	public ObiektKontakt(){
		
	}
	
	public ObiektKontakt(String obiektTelefon, String obiektFax, String obiektEmail){
		this.obiektTelefon = obiektTelefon;
		this.obiektFax = obiektFax;
		this.obiektEmail = obiektEmail;
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

	public String getObiektTelefon() {
		return obiektTelefon;
	}

	public void setObiektTelefon(String obiektTelefon) {
		this.obiektTelefon = obiektTelefon;
	}

	public String getObiektFax() {
		return obiektFax;
	}

	public void setObiektFax(String obiektFax) {
		this.obiektFax = obiektFax;
	}

	public String getObiektEmail() {
		return obiektEmail;
	}

	public void setObiektEmail(String obiektEmail) {
		this.obiektEmail = obiektEmail;
	}
	
}
