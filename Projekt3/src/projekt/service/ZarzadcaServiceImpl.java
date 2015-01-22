package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.ZarzadcaDao;
import projekt.model.Zarzadca;

@Service("zarzadcaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ZarzadcaServiceImpl implements ZarzadcaService{

	@Autowired
	private ZarzadcaDao zarzadcaDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addZarzadca(Zarzadca zarzadca) {
		zarzadcaDao.addZarzadca(zarzadca);
	}

	public List<Zarzadca> zarzadcaList() {
		return zarzadcaDao.zarzadcaList();
	}

	public Zarzadca getZarzadca(int zarzadcaId) {
		return zarzadcaDao.getZarzadca(zarzadcaId);
	}

	public void deleteZarzadca(Zarzadca zarzadca) {
		zarzadcaDao.deleteZarzadca(zarzadca);
	}

}
