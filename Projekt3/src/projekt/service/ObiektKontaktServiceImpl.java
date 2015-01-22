package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.ObiektKontaktDao;
import projekt.model.ObiektKontakt;

@Service("obiektKontaktService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ObiektKontaktServiceImpl implements ObiektKontaktService{
	
	@Autowired
	ObiektKontaktDao obiektKontaktDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addObiektKontakt(ObiektKontakt obiektKontakt) {
		obiektKontaktDao.addObiektKontakt(obiektKontakt);
	}
	
	public List<ObiektKontakt> obiektKontaktList() {
		return obiektKontaktDao.obiektKontaktList();
	}
	
	public ObiektKontakt getObiektKontakt(int obiektId) {
		return obiektKontaktDao.getObiektKontakt(obiektId);
	}

	public void deleteObiektKontakt(ObiektKontakt obiektKontakt) {
		obiektKontaktDao.deleteObiektKontakt(obiektKontakt);
	}

}
