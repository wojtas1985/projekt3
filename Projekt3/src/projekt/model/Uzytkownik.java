package projekt.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Uzytkownik")
public class Uzytkownik implements Serializable{

	private static final long serialVersionUID = 8487994274697338365L;

	private Integer uzytkownikId;
	private String uzytkownikLogin;
	private String uzytkownikHaslo;
	private Boolean uzytkownikEnabled;
	private List<UzytkownikRole> roles;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UzytkownikId")
	public Integer getUzytkownikId() {
		return this.uzytkownikId;
	}
	public void setUzytkownikId(Integer uzytkownikId) {
		this.uzytkownikId = uzytkownikId;
	}
	
	@Column(name="Login")
	public String getUzytkownikLogin() {
		return this.uzytkownikLogin;
	}
	public void setUzytkownikLogin(String uzytkownikLogin) {
		this.uzytkownikLogin = uzytkownikLogin;
	}
	
	@Column(name="Haslo")
	public String getUzytkownikHaslo() {
		return this.uzytkownikHaslo;
	}
	public void setUzytkownikHaslo(String uzytkownikHaslo) {
		this.uzytkownikHaslo = uzytkownikHaslo;
	}
	
	@Column(name="Enabled")
	public Boolean getUzytkownikEnabled() {
		return this.uzytkownikEnabled;
	}
	public void setUzytkownikEnabled(Boolean uzytkownikEnabled) {
		this.uzytkownikEnabled = uzytkownikEnabled;
	}

	@OneToMany(mappedBy="uzytkownik")
	@OnDelete(action=OnDeleteAction.CASCADE)
	public List<UzytkownikRole> getRoles() {
		return this.roles;
	}

	public void setRoles(List<UzytkownikRole> roles) {
		this.roles = roles;
	}
	
}
