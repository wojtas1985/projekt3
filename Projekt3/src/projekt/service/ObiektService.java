package projekt.service;

import java.util.List;

import projekt.model.Obiekt;

public interface ObiektService {

public void addObiekt(Obiekt obiekt);
	
	public List<Obiekt> obiektList();
	
	public Obiekt getObiekt(int obiektId);
	
	public void deleteObiekt(Obiekt obiekt);
	
}
