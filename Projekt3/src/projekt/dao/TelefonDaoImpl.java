package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Telefon;

@Transactional
@Repository("telefonDao")
public class TelefonDaoImpl implements TelefonDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTelefon(Telefon telefon) {
		sessionFactory.getCurrentSession().saveOrUpdate(telefon);
	}

	@SuppressWarnings("unchecked")
	public List<Telefon> telefonList() {
		return (List<Telefon>) sessionFactory.getCurrentSession()
				.createCriteria(Telefon.class).list();
	}

	public Telefon getTelefon(int telefonId) {
		return (Telefon) sessionFactory.getCurrentSession().get(Telefon.class,
				telefonId);
	}

	public void deleteTelefon(Telefon telefon) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"DELETE FROM Telefon WHERE telefonId = "
								+ telefon.getTelefonId()).executeUpdate();
	}

}
