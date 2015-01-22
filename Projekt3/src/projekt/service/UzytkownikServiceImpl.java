package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.UzytkownikDao;
import projekt.model.Uzytkownik;

@Service("uzytkownikService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UzytkownikServiceImpl implements UzytkownikService{

	@Autowired
	UzytkownikDao uzytkownikDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUzytkownik(Uzytkownik uzytkownik) {
		uzytkownikDao.addUzytkownik(uzytkownik);
	}


	public List<Uzytkownik> uzytkownikList() {
		return uzytkownikDao.uzytkownikList();
	}

	public Uzytkownik getUzytkownik(int uzytkownikId) {
		return uzytkownikDao.getUzytkownik(uzytkownikId);
	}

	public void deleteUzytkownik(Uzytkownik uzytkownik) {
		uzytkownikDao.deleteUzytkownik(uzytkownik);
	}

	
	
}
