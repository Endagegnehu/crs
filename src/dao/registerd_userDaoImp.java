package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.address;
import entity.crime_log;
import entity.users;

@Repository
public class registerd_userDaoImp implements registerd_usersDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<users> getRegisterdUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<users> users_registerd = currentSession.createQuery("from users", users.class);
		List<users> users_get_users = users_registerd.getResultList();
		return users_get_users;
	}
	@Override
	@Transactional
	public List<address> getRegisterdUsersAddres() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<address> users_registerd = currentSession.createQuery("from address", address.class);
		List<address> users_get_users = users_registerd.getResultList();
		return users_get_users;
	}
	@Override
	@Transactional
	public int getRegisterdUsersID(int theID) {
		Session currentSession = sessionFactory.getCurrentSession();
		users user_address_new = currentSession.get(users.class, theID);
		return user_address_new.getAddress_new().getIdaddres();
	}

}
