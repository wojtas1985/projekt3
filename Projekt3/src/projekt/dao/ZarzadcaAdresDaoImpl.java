package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.ZarzadcaAdres;

@Transactional
@Repository("zarzadcaAdresDao")
public class ZarzadcaAdresDaoImpl implements ZarzadcaAdresDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addZarzadcaAdres(ZarzadcaAdres zarzadcaAdres) {
		sessionFactory.getCurrentSession().saveOrUpdate(zarzadcaAdres);
	}

	@SuppressWarnings("unchecked")
	public List<ZarzadcaAdres> zarzadcaAdresList() {
		return (List<ZarzadcaAdres>) sessionFactory.getCurrentSession().createCriteria(ZarzadcaAdres.class).list();
	}

	public ZarzadcaAdres getZarzadcaAdres(int zarzadcaId) {
		return (ZarzadcaAdres) sessionFactory.getCurrentSession().get(ZarzadcaAdres.class, zarzadcaId);
	}

	public void deleteZarzadcaAdres(ZarzadcaAdres zarzadcaAdres) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ZarzadcaAdres WHERE zarzadcaId = "+zarzadcaAdres.getZarzadcaId()).executeUpdate();
	}

}
