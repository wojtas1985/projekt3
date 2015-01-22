package projekt.dao;

import java.util.List;

import projekt.model.Obiekt;

public interface ObiektDao {

	public void addObiekt(Obiekt obiekt);
	
	public List<Obiekt> obiektList();
	
	public Obiekt getObiekt(int obiektId);
	
	public void deleteObiekt(Obiekt obiekt);
	
}
