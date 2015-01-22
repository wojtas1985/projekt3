package projekt.service;

import java.util.List;

import projekt.model.Woda;

public interface WodaService {

	public void addWoda(Woda woda);
	
	public List<Woda> wodaList();
	
	public Woda getWoda(int odczytId);
	
	public void deleteWoda(Woda woda);
	
}
