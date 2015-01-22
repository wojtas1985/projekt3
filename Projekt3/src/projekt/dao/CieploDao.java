package projekt.dao;

import java.util.List;

import projekt.model.Cieplo;

public interface CieploDao {

	public void addCieplo(Cieplo cieplo);
	
	public List<Cieplo> cieploList();
	
	public Cieplo getCieplo (int odczytId);
	
	public void deleteCieplo(Cieplo cieplo);
	
}