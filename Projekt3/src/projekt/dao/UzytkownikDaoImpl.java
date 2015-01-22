package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Uzytkownik;

@Transactional
@Repository("uzytkownikDao")
public class UzytkownikDaoImpl implements UzytkownikDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUzytkownik(Uzytkownik uzytkownik) {
		sessionFactory.getCurrentSession().saveOrUpdate(uzytkownik);	
	}

	@SuppressWarnings("unchecked")
	public List<Uzytkownik> uzytkownikList() {
		return (List<Uzytkownik>) sessionFactory.getCurrentSession().createCriteria(Uzytkownik.class).list();
	}

	public Uzytkownik getUzytkownik(int uzytkownikId) {
		return (Uzytkownik) sessionFactory.getCurrentSession().get(Uzytkownik.class, uzytkownikId);
	}

	public void deleteUzytkownik(Uzytkownik uzytkownik) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Uzytkownik WHERE uzytkownikid = "+uzytkownik.getUzytkownikId()).executeUpdate();
	}

}
