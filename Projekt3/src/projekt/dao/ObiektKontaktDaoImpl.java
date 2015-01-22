package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.ObiektKontakt;

@Transactional
@Repository("obiektKontaktDao")
public class ObiektKontaktDaoImpl implements ObiektKontaktDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	public void addObiektKontakt(ObiektKontakt obiektKontakt) {
		sessionFactory.getCurrentSession().saveOrUpdate(obiektKontakt);
	}

	@SuppressWarnings("unchecked")
	public List<ObiektKontakt> obiektKontaktList() {
		return (List<ObiektKontakt>) sessionFactory.getCurrentSession().createCriteria(ObiektKontakt.class).list();
	}

	public ObiektKontakt getObiektKontakt(int obiektId) {
		return (ObiektKontakt) sessionFactory.getCurrentSession().get(ObiektKontakt.class, obiektId);
	}

	public void deleteObiektKontakt(ObiektKontakt obiektKontakt) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ObiektKontakt WHERE obiektId = "+obiektKontakt.getObiektId()).executeUpdate();
	}

}
