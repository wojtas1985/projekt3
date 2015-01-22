package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Odczyt;

@Transactional
@Repository("odczytDao")
public class OdczytDaoImpl implements OdczytDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addOdczyt(Odczyt odczyt) {
		sessionFactory.getCurrentSession().saveOrUpdate(odczyt);
	}

	@SuppressWarnings("unchecked")
	public List<Odczyt> odczytList() {
		return (List<Odczyt>) sessionFactory.getCurrentSession().createCriteria(Odczyt.class).list();
	}

	public Odczyt getOdczyt(int odczytId) {
		return (Odczyt) sessionFactory.getCurrentSession().get(Odczyt.class, odczytId);
	}

	public void deleteOdczyt(Odczyt odczyt) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Odczyt WHERE odczytId = "+odczyt.getOdczytId()).executeUpdate();
		
	}
}
