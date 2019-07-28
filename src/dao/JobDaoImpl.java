package dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.job;
import entity.users;
@Repository
public class JobDaoImpl implements JobDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public void saveJob(job user_job) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(user_job);

	}
	@Override
	@Transactional
	public List<job> getofficer() {
		
        Session currentsession = sessionFactory.getCurrentSession();
        
        List<job> officersList = currentsession.createQuery("from job off where off.name='police'", job.class).getResultList();
        
		return officersList;
	}

}
