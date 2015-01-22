package projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projekt.dao.InternetDao;
import projekt.model.Internet;

@Service("internetService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InternetServiceImpl implements InternetService{
	
	@Autowired
	private InternetDao internetDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addInternet(Internet internet) {
		internetDao.addInternet(internet);
	}

	public List<Internet> internetList() {
		return internetDao.internetList();
	}

	public Internet getInternet(int internetId) {
		return internetDao.getInternet(internetId);
	}

	public void deleteInternet(Internet internet) {
		internetDao.deleteInternet(internet);
	}

}
