package projekt.dao;

import java.util.List;

import projekt.model.ObiektAdres;

public interface ObiektAdresDao {

	public void addObiektAdres(ObiektAdres obiektAdres);
	
	public List<ObiektAdres> obiektAdresList();
	
	public ObiektAdres getObiektAdres(int obiektId);
	
	public void deleteObiektAdres (ObiektAdres obiektAdres);
	
}
