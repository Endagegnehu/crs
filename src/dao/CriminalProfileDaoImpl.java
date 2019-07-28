package dao;

import entity.address;
import entity.crime_log;
import entity.criminal_profile;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CriminalProfileDaoImpl implements CriminalProfileDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public String SaveSuspect(criminal_profile criminalprofile, address address) 
    {
        Session session = sessionFactory.getCurrentSession();
        
        session.save(criminalprofile);
        session.save(address);
        return "index";
    }
    
    @Transactional
	@Override
	public void save(criminal_profile criminalprofile) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(criminalprofile);
		
	}
    
    @Transactional
	@Override
	public List<criminal_profile> getRegisteredSuspects() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<criminal_profile> theCrime = currentSession.createQuery("from criminal_profile", criminal_profile.class);
		List<criminal_profile> suspect = theCrime.getResultList();
		
		return suspect;
	}
	
    
}
