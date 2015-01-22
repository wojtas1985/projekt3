package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.ObiektDao;
import projekt.model.Obiekt;

@Service("obiektService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ObiektServiceImpl implements ObiektService{
	
	@Autowired
	private ObiektDao obiektDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addObiekt(Obiekt obiekt) {
		obiektDao.addObiekt(obiekt);		
	}
	
	public List<Obiekt> obiektList() {
		return  obiektDao.obiektList();
	}

	public Obiekt getObiekt(int obiektId) {
		return obiektDao.getObiekt(obiektId);
	}

	public void deleteObiekt(Obiekt obiekt) {
		obiektDao.deleteObiekt(obiekt);
	}

}
