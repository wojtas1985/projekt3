package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.EnergiaDao;
import projekt.model.Energia;

@Service("energiaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EnergiaServiceImpl implements EnergiaService{
	
	@Autowired
	private EnergiaDao energiaDao;
	
	public void addEnergia(Energia energia) {
		energiaDao.addEnergia(energia);		
	}

	public List<Energia> energiaList() {
		return energiaDao.energiaList();
	}

	public Energia getErnergia(int odczytId) {
		return energiaDao.getErnergia(odczytId);
	}

	public void deleteEnergia(Energia energia) {
		energiaDao.deleteEnergia(energia);
	}

}
