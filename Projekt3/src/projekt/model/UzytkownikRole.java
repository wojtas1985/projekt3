package projekt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UzytkownikRole")
public class UzytkownikRole implements Serializable{

	private static final long serialVersionUID = -3457487841790122197L;
	
	private Integer uzytkownikRolaId;
	private Uzytkownik uzytkownik;
	private String uzytkownikRola;

	@Id
	@GeneratedValue
	@Column(name="rolaId")
	public Integer getUzytkownikRolaId() {
		return this.uzytkownikRolaId;
	}

	public void setUzytkownikRolaId(Integer uzytkownikRolaId) {
		this.uzytkownikRolaId = uzytkownikRolaId;
	}

	
	@ManyToOne
	@JoinColumn(name = "UzytkownikId")
	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	@Column(name="rola")
	public String getUzytkownikRola() {
		return this.uzytkownikRola;
	}

	public void setUzytkownikRola(String uzytkownikRola) {
		this.uzytkownikRola = uzytkownikRola;
	}
	
}
