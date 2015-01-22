package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.ZarzadcaAdresDao;
import projekt.model.ZarzadcaAdres;

@Service("zarzadcaAdresService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ZarzadcaAdresServiceImpl implements ZarzadcaAdresService{

	@Autowired
	private ZarzadcaAdresDao zarzadcaAdresDao;
	
	public void addZarzadcaAdres(ZarzadcaAdres zarzadcaAdres) {
		zarzadcaAdresDao.addZarzadcaAdres(zarzadcaAdres);
	}

	public List<ZarzadcaAdres> zarzadcaAdresList() {
		return zarzadcaAdresDao.zarzadcaAdresList();
	}

	public ZarzadcaAdres getZarzadcaAdres(int zarzadcaId) {
		return zarzadcaAdresDao.getZarzadcaAdres(zarzadcaId);
	}

	public void deleteZarzadcaAdres(ZarzadcaAdres zarzadcaAdres) {
		zarzadcaAdresDao.deleteZarzadcaAdres(zarzadcaAdres);
	}

}
