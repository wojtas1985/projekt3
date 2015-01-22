package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.TelefonDao;
import projekt.model.Telefon;

@Service("telefonService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TelefonServiceImpl implements TelefonService{
	
	@Autowired
	private TelefonDao telefonDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTelefon(Telefon telefon) {
		telefonDao.addTelefon(telefon);
	}

	public List<Telefon> telefonList() {
		return telefonDao.telefonList();
	}

	public Telefon getTelefon(int telefonId) {
		return telefonDao.getTelefon(telefonId);
	}

	public void deleteTelefon(Telefon telefon) {
		telefonDao.deleteTelefon(telefon);
	}

}
