package projekt.service;

import java.util.List;

import projekt.model.UzytkownikRole;

public interface UzytkownikRoleService {

public void addUzytkownikRole(UzytkownikRole uzytkownikRole);
	
	public List<UzytkownikRole> uzytkownikRoleList();
	
	public UzytkownikRole getUzytkownikRole(int uzytkownikRoleId);
	
	public void deleteUzytkownikRole(UzytkownikRole uzytkownikRole);
	
}
