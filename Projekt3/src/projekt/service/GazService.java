package projekt.service;

import java.util.List;

import projekt.model.Gaz;

public interface GazService {

	public void addGaz(Gaz gaz);
	
	public List<Gaz> gazList();
	
	public Gaz getGaz(int odczytId);
	
	public void deleteGaz(Gaz gaz);
	
}
