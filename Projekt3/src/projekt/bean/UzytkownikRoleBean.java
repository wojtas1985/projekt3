package projekt.bean;

public class UzytkownikRoleBean {

	private Integer id;
	private UzytkownikBean uzytkownikBean;
	private String rola;
	
	public UzytkownikRoleBean(){
		
	}
	
	public UzytkownikRoleBean(UzytkownikBean uzytkownikBean, String rola){
		this.uzytkownikBean = uzytkownikBean;
		this.rola = rola;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRola() {
		return rola;
	}
	public void setRola(String rola) {
		this.rola = rola;
	}

	public UzytkownikBean getUzytkownikBean() {
		return uzytkownikBean;
	}

	public void setUzytkownikBean(UzytkownikBean uzytkownikBean) {
		this.uzytkownikBean = uzytkownikBean;
	}

}
