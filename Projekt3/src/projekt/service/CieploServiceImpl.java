package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.CieploDao;
import projekt.model.Cieplo;

@Service("cieploService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CieploServiceImpl implements CieploService{

	@Autowired
	private CieploDao cieploDao;
	
	public void addCieplo(Cieplo cieplo) {
		cieploDao.addCieplo(cieplo);		
	}

	public List<Cieplo> cieploList() {
		return cieploDao.cieploList();
	}

	public Cieplo getCieplo(int odczytId) {
		return cieploDao.getCieplo(odczytId);
	}

	public void deleteCieplo(Cieplo cieplo) {
		cieploDao.deleteCieplo(cieplo);
	}

}
