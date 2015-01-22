package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Internet;

@Transactional
@Repository("internetDao")
public class InternetDaoImpl implements InternetDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addInternet(Internet internet) {
		sessionFactory.getCurrentSession().saveOrUpdate(internet);		
	}

	@SuppressWarnings("unchecked")
	public List<Internet> internetList() {
		return (List<Internet>) sessionFactory.getCurrentSession().createCriteria(Internet.class).list();
	}

	public Internet getInternet(int internetId) {
		return (Internet) sessionFactory.getCurrentSession().get(Internet.class, internetId);
	}

	public void deleteInternet(Internet internet) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"DELETE FROM Internet WHERE internetId = "
								+ internet.getInternetId()).executeUpdate();
	}
	
	

}
