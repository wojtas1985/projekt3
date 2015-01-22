package projekt.dao;

import java.util.List;

import projekt.model.UzytkownikRole;

public interface UzytkownikRoleDao {

public void addUzytkownikRole(UzytkownikRole uzytkownikRole);
	
	public List<UzytkownikRole> uzytkownikRoleList();
	
	public UzytkownikRole getUzytkownikRole(int uzytkownikRoleId);
	
	public void deleteUzytkownikRole(UzytkownikRole uzytkownikRole);
	
}
