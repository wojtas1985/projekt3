package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Obiekt;
@Transactional
@Repository("obiektDao")
public class ObiektDaoImpl implements ObiektDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addObiekt(Obiekt obiekt) {
		sessionFactory.getCurrentSession().saveOrUpdate(obiekt);
	}

	@SuppressWarnings("unchecked")
	public List<Obiekt> obiektList() {
		return (List<Obiekt>) sessionFactory.getCurrentSession().createCriteria(Obiekt.class).list();
	}

	public Obiekt getObiekt(int obiektId) {
		return (Obiekt) sessionFactory.getCurrentSession().get(Obiekt.class, obiektId);
	}

	public void deleteObiekt(Obiekt obiekt) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Obiekt WHERE obiektId = "+obiekt.getObiektId()).executeUpdate();
	}

}
