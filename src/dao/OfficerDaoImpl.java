package dao;

import entity.job;
import entity.users;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OfficerDaoImpl implements OfficerDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<String> getOfficers() 
    {
        List<String> offlist = new ArrayList();
        ArrayList<Integer> idList = new ArrayList(); 
        
        Session currentsession = sessionFactory.getCurrentSession();
        
        List<job> officersList = currentsession.createQuery("from job off where off.name='investigator'", job.class).getResultList();       
        
        for(job tempjob : officersList)
        {
        	offlist.add(tempjob.getUsers_idusers().getUser_name());
        }
        
        
        return offlist;
    }
    
}
