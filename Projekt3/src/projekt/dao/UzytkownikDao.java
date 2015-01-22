package projekt.dao;

import java.util.List;

import projekt.model.Uzytkownik;

public interface UzytkownikDao {

	public void addUzytkownik(Uzytkownik uzytkownik);
	
	public List<Uzytkownik> uzytkownikList();
	
	public Uzytkownik getUzytkownik(int uzytkownikId);
	
	public void deleteUzytkownik(Uzytkownik uzytkownik);
	
}
