package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.users;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveUser(users users_new) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(users_new);
	}

	@Override
	@Transactional
	public users getUser(int theID) {
		Session currentSession = sessionFactory.getCurrentSession();
		users theUser = currentSession.get(users.class, theID);
		 
		return theUser;
	}

	@Override
	public void update(users users_form_page, int theID) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		users theUser = currentSession.get(users.class, theID);
		theUser.setFirst_name(users_form_page.getFirst_name());
		theUser.setLast_name(users_form_page.getLast_name());
		theUser.setUser_name(users_form_page.getUser_name());
		theUser.setPassword(users_form_page.getPassword());
		theUser.setEmail(users_form_page.getEmail());
	}

	@Override
	public void deleteUser(int theID) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		users the_user_to_delete = currentSession.get(users.class, theID);
		currentSession.delete(the_user_to_delete);
		
	}

}
