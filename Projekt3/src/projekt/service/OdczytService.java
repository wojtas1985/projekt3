package projekt.service;

import java.util.List;

import projekt.model.Odczyt;

public interface OdczytService {

	public void addOdczyt(Odczyt odczyt);

	public List<Odczyt> odczytList();
	
	public Odczyt getOdczyt(int odczytId);
	
	public void deleteOdczyt(Odczyt odczyt);
}
