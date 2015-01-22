package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Gaz;

@Transactional
@Repository("gazDao")
public class GazDaoImpl implements GazDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void addGaz(Gaz gaz) {
		sessionFactory.getCurrentSession().saveOrUpdate(gaz);
		
	}

	@SuppressWarnings("unchecked")
	public List<Gaz> gazList() {
		return (List<Gaz>) sessionFactory.getCurrentSession().createCriteria(Gaz.class).list();
	}

	public Gaz getGaz(int odczytId) {
		return (Gaz) sessionFactory.getCurrentSession().get(Gaz.class, odczytId);
	}

	public void deleteGaz(Gaz gaz) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Gaz WHERE odczytId = "+gaz.getOdczytId()).executeUpdate();
	}
}
