package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Energia;

@Transactional
@Repository("energiaDao")
public class EnergiaDaoImpl implements EnergiaDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void addEnergia(Energia energia) {
		sessionFactory.getCurrentSession().saveOrUpdate(energia);
		
	}

	@SuppressWarnings("unchecked")
	public List<Energia> energiaList() {
		return (List<Energia>) sessionFactory.getCurrentSession().createCriteria(Energia.class).list();
	}

	public Energia getErnergia(int odczytId) {
		return (Energia) sessionFactory.getCurrentSession().get(Energia.class, odczytId);
	}

	public void deleteEnergia(Energia energia) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Energia WHERE odczytId = "+energia.getOdczytId()).executeUpdate();
	}

}