package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Woda;

@Transactional
@Repository("wodaDao")
public class WodaDaoImpl implements WodaDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addWoda(Woda woda){
		sessionFactory.getCurrentSession().saveOrUpdate(woda);
	}

	@SuppressWarnings("unchecked")
	public List<Woda> wodaList() {
		return (List<Woda>) sessionFactory.getCurrentSession().createCriteria(Woda.class).list();
	}

	public Woda getWoda(int odczytId) {
		return (Woda) sessionFactory.getCurrentSession().get(Woda.class, odczytId);
	}

	public void deleteWoda(Woda woda) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Woda WHERE odczytId = "+woda.getOdczytId()).executeUpdate();
	}
}
