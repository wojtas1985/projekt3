package projekt.service;

import java.util.List;

import projekt.model.Energia;

public interface EnergiaService {
	
	public void addEnergia(Energia energia);
	
	public List<Energia> energiaList();
	
	public Energia getErnergia(int odczytId);
	
	public void deleteEnergia(Energia energia);

}
