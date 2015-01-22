package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.ObiektAdresDao;
import projekt.model.ObiektAdres;

@Service("obiektAdresService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ObiektAdresServiceImpl implements ObiektAdresService{

	@Autowired
	ObiektAdresDao obiektAdresDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addObiektAdres(ObiektAdres obiektAdres) {
		obiektAdresDao.addObiektAdres(obiektAdres);
	}

	public List<ObiektAdres> obiektAdresList() {
		return obiektAdresDao.obiektAdresList();
	}

	public ObiektAdres getObiektAdres(int obiektId) {
		return obiektAdresDao.getObiektAdres(obiektId);
	}

	public void deleteObiektAdres(ObiektAdres obiektAdres) {
		obiektAdresDao.deleteObiektAdres(obiektAdres);
	}

}
