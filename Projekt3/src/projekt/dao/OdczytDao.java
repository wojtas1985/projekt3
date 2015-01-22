package projekt.dao;

import java.util.List;

import projekt.model.Odczyt;

public interface OdczytDao {
	
	public void addOdczyt(Odczyt odczyt);

	public List<Odczyt> odczytList();
	
	public Odczyt getOdczyt(int odczytId);
	
	public void deleteOdczyt(Odczyt odczyt);

}
