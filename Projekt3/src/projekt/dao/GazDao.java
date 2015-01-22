package projekt.dao;

import java.util.List;

import projekt.model.Gaz;

public interface GazDao {

	public void addGaz(Gaz gaz);
	
	public List<Gaz> gazList();
	
	public Gaz getGaz(int odczytId);
	
	public void deleteGaz(Gaz gaz);
	
}
