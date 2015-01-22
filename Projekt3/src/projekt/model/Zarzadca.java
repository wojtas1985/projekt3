package projekt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Zarzadca")
public class Zarzadca implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5957569481540253219L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="zarzadcaId")
	private Integer zarzadcaId;
	
	@Column(name="Imie")
	private String zarzadcaImie;
	
	@Column(name="Nazwisko")
	private String zarzadcaNazwisko;
	
	@Column(name="DataUrodzenia")
	@Temporal(TemporalType.DATE)
	private Date zarzadcaDataUrodzenia;
	
	@Column(name="Telefon")
	private String zarzadcaTelefon;
	
	@Column(name="Email")
	private String zarzadcaEmail;
	
	@ManyToOne
	@JoinColumn(name="obiektId", insertable=false, updatable=false)
	private Obiekt obiekt;

	private Integer obiektId;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="zarzadca", orphanRemoval=true)
	private ZarzadcaAdres zarzadcaAdres;
	
	public Zarzadca(){
		
	}
	
	public Zarzadca(String zarzadcaImie, String zarzadcaNazwisko, Date zarzadcaDataUrodzenia,
			String zarzadcaTelefon, String zarzadcaEmail, Integer obiektId){
		this.zarzadcaImie = zarzadcaImie;
		this.zarzadcaNazwisko = zarzadcaNazwisko;
		this.zarzadcaDataUrodzenia = zarzadcaDataUrodzenia;
		this.zarzadcaTelefon = zarzadcaTelefon;
		this.zarzadcaEmail = zarzadcaEmail;
		this.obiektId = obiektId;
	}

	public Integer getZarzadcaId() {
		return zarzadcaId;
	}

	public void setZarzadcaId(Integer zarzadcaId) {
		this.zarzadcaId = zarzadcaId;
	}

	public String getZarzadcaImie() {
		return zarzadcaImie;
	}

	public void setZarzadcaImie(String zarzadcaImie) {
		this.zarzadcaImie = zarzadcaImie;
	}

	public String getZarzadcaNazwisko() {
		return zarzadcaNazwisko;
	}

	public void setZarzadcaNazwisko(String zarzadcaNazwisko) {
		this.zarzadcaNazwisko = zarzadcaNazwisko;
	}

	public Date getZarzadcaDataUrodzenia() {
		return zarzadcaDataUrodzenia;
	}

	public void setZarzadcaDataUrodzenia(Date zarzadcaDataUrodzenia) {
		this.zarzadcaDataUrodzenia = zarzadcaDataUrodzenia;
	}

	public String getZarzadcaTelefon() {
		return zarzadcaTelefon;
	}

	public void setZarzadcaTelefon(String zarzadcaTelefon) {
		this.zarzadcaTelefon = zarzadcaTelefon;
	}

	public String getZarzadcaEmail() {
		return zarzadcaEmail;
	}

	public void setZarzadcaEmail(String zarzadcaEmail) {
		this.zarzadcaEmail = zarzadcaEmail;
	}

	public Integer getObiektId() {
		return obiektId;
	}

	public void setObiektId(Integer obiektId) {
		this.obiektId = obiektId;
	}

	public ZarzadcaAdres getZarzadcaAdres() {
		return zarzadcaAdres;
	}

	public void setZarzadcaAdres(ZarzadcaAdres zarzadcaAdres) {
		this.zarzadcaAdres = zarzadcaAdres;
	}
	
}
