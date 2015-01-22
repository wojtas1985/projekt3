package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.WodaDao;
import projekt.model.Woda;

@Service("wodaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class WodaServiceImpl implements WodaService{
	
	@Autowired
	private WodaDao wodaDao;
	
	public void addWoda(Woda woda){
		wodaDao.addWoda(woda);
	}

	public List<Woda> wodaList() {
		return wodaDao.wodaList();
	}

	public Woda getWoda(int odczytId) {
		return wodaDao.getWoda(odczytId);
	}

	public void deleteWoda(Woda woda) {
		wodaDao.deleteWoda(woda);
	}

}
