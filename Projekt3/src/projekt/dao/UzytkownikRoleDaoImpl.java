package projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projekt.model.UzytkownikRole;

@Transactional
@Repository("uzytkownikRoleDao")
public class UzytkownikRoleDaoImpl implements UzytkownikRoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUzytkownikRole(UzytkownikRole uzytkownikRole) {
		sessionFactory.getCurrentSession().saveOrUpdate(uzytkownikRole);		
	}

	@SuppressWarnings("unchecked")
	public List<UzytkownikRole> uzytkownikRoleList() {
		return (List<UzytkownikRole>) sessionFactory.getCurrentSession().createCriteria(UzytkownikRole.class).list();
	}

	public UzytkownikRole getUzytkownikRole(int uzytkownikId) {
		return (UzytkownikRole) sessionFactory.getCurrentSession().get(UzytkownikRole.class, uzytkownikId);
	}

	public void deleteUzytkownikRole(UzytkownikRole uzytkownikRole) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM UzytkownikRole WHERE uzytkownikId = "+uzytkownikRole.getUzytkownik().getUzytkownikId()).executeUpdate();
	}

}
