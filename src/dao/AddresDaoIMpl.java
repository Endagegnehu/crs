package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.address;

@Repository
public class AddresDaoIMpl implements Address {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveAddres(address address_user) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(address_user);

	}
	
	
	@Override
	@Transactional
	public address getUserAddres(int theID) {
		Session currentSession = sessionFactory.getCurrentSession();
		address user_address_new = currentSession.get(address.class, theID);
		return user_address_new;
	}


	@Override
	@Transactional
	public void saveAddresUpdate(address address_user,int teID) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		address user_address_new = currentSession.get(address.class, teID);
		user_address_new.setHome_number(address_user.getHome_number());
		user_address_new.setPhon(address_user.getPhon());
		user_address_new.setRegion(address_user.getRegion());
		user_address_new.setWoreda(address_user.getWoreda());
		user_address_new.setKebele(address_user.getKebele());
		
	}

}
