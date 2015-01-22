package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.GazDao;
import projekt.model.Gaz;

@Service("gazService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GazServiceImpl implements GazService{

	@Autowired
	private GazDao gazDao;
	
	public void addGaz(Gaz gaz){
		gazDao.addGaz(gaz);
	}

	public List<Gaz> gazList() {
		return gazDao.gazList();
	}

	public Gaz getGaz(int odczytId) {
		return gazDao.getGaz(odczytId);
	}

	public void deleteGaz(Gaz gaz) {
		gazDao.deleteGaz(gaz);
	}
}
