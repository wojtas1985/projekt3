package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.OdczytDao;
import projekt.model.Odczyt;

@Service("odczytService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OdczytServiceImpl implements OdczytService {

	@Autowired
	private OdczytDao odczytDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOdczyt(Odczyt odczyt) {
		odczytDao.addOdczyt(odczyt);
	}
	
	public List<Odczyt> odczytList() {
		return odczytDao.odczytList();
	}

	public Odczyt getOdczyt(int odczytId) {
		return odczytDao.getOdczyt(odczytId);
	}

	public void deleteOdczyt(Odczyt odczyt) {
		odczytDao.deleteOdczyt(odczyt);
		
	}
}
