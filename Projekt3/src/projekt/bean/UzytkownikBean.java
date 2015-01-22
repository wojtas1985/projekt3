package projekt.bean;

import java.io.Serializable;
import java.util.List;

import projekt.model.UzytkownikRole;

public class UzytkownikBean implements Serializable{

	private static final long serialVersionUID = 7767329333551476081L;
	
	private Integer id;
	private String login;
	private String haslo;
	private Boolean enabled;
	private List<UzytkownikRole> roles;
	
	public UzytkownikBean(){
		
	}
	
	public UzytkownikBean(String login, String haslo, Boolean enabled, List<UzytkownikRole> roles){
		this.login = login;
		this.haslo =haslo;
		this.enabled = enabled;
		this.roles = roles;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<UzytkownikRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UzytkownikRole> roles) {
		this.roles = roles;
	}

	
}
