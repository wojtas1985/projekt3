package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.ObiektAdres;

@Transactional
@Repository("obiektAdresDao")
public class ObiektAdresDaoImpl implements ObiektAdresDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addObiektAdres(ObiektAdres obiektAdres) {
		sessionFactory.getCurrentSession().saveOrUpdate(obiektAdres);
	}

	@SuppressWarnings("unchecked")
	public List<ObiektAdres> obiektAdresList() {
		return (List<ObiektAdres>) sessionFactory.getCurrentSession().createCriteria(ObiektAdres.class).list();
	}

	public ObiektAdres getObiektAdres(int obiektId) {
		return (ObiektAdres) sessionFactory.getCurrentSession().get(ObiektAdres.class, obiektId);
	}

	public void deleteObiektAdres(ObiektAdres obiektAdres) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ObiektAdres WHERE obiektId = "+obiektAdres.getObiektId()).executeUpdate();
	}

}
