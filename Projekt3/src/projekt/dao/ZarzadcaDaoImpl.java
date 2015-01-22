package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.Zarzadca;

@Transactional
@Repository("zarzadcaDao")
public class ZarzadcaDaoImpl implements ZarzadcaDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public void addZarzadca(Zarzadca zarzadca) {
		sessionFactory.getCurrentSession().saveOrUpdate(zarzadca);
	}

	@SuppressWarnings("unchecked")
	public List<Zarzadca> zarzadcaList() {
		return (List<Zarzadca>) sessionFactory.getCurrentSession().createCriteria(Zarzadca.class).list();
	}

	public Zarzadca getZarzadca(int zarzadcaId) {
		return (Zarzadca) sessionFactory.getCurrentSession().get(Zarzadca.class, zarzadcaId);
	}

	public void deleteZarzadca(Zarzadca zarzadca) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Zarzadca WHERE zarzadcaId = "+zarzadca.getZarzadcaId()).executeUpdate();
	}

}
