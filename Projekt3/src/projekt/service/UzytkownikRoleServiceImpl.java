package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.UzytkownikRoleDao;
import projekt.model.UzytkownikRole;

@Service("uzytkownikRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UzytkownikRoleServiceImpl implements UzytkownikRoleService{

	@Autowired
	UzytkownikRoleDao uzytkownikRoleDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUzytkownikRole(UzytkownikRole uzytkownikRole) {
		uzytkownikRoleDao.addUzytkownikRole(uzytkownikRole);
	}


	public List<UzytkownikRole> uzytkownikRoleList() {
		return uzytkownikRoleDao.uzytkownikRoleList();
	}
	
	public UzytkownikRole getUzytkownikRole(int uzytkownikRoleId) {
		return uzytkownikRoleDao.getUzytkownikRole(uzytkownikRoleId);
	}
	
	public void deleteUzytkownikRole(UzytkownikRole uzytkownikRole) {
		uzytkownikRoleDao.deleteUzytkownikRole(uzytkownikRole);
	}

}
