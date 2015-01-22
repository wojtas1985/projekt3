package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Cieplo;

@Transactional
@Repository("cieploDao")
public class CieploDaoImpl implements CieploDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void addCieplo(Cieplo cieplo) {
		sessionFactory.getCurrentSession().saveOrUpdate(cieplo);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cieplo> cieploList() {
		return (List<Cieplo>) sessionFactory.getCurrentSession().createCriteria(Cieplo.class).list();
	}

	public Cieplo getCieplo(int odczytId) {
		return (Cieplo) sessionFactory.getCurrentSession().get(Cieplo.class, odczytId);
	}

	public void deleteCieplo(Cieplo cieplo) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Cieplo WHERE odczytId = "+cieplo.getOdczytId()).executeUpdate();
	}

}
