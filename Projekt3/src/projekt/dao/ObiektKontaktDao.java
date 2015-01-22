package projekt.dao;

import java.util.List;

import projekt.model.ObiektKontakt;

public interface ObiektKontaktDao {

	public void addObiektKontakt(ObiektKontakt obiektKontakt);
	
	public List<ObiektKontakt> obiektKontaktList();
	
	public ObiektKontakt getObiektKontakt(int obiektId);
	
	public void deleteObiektKontakt(ObiektKontakt obiektKontakt);
	
	
}
