package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import entity.crime_log;

@Repository
public class registered_crimesImpl implements registered_crimes {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<crime_log> getRegisteredCrimes() {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<crime_log> theCrime = currentSession.createQuery("from crime_log", crime_log.class);
		List<crime_log> crimLog = theCrime.getResultList();
		
		return crimLog;
	}

}
