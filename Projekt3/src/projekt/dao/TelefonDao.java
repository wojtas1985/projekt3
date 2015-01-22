package projekt.dao;

import java.util.List;

import projekt.model.Telefon;

public interface TelefonDao {

	public void addTelefon(Telefon telefon);

	public List<Telefon> telefonList();
	
	public Telefon getTelefon(int telefonId);
	
	public void deleteTelefon(Telefon telefon);
	
}
