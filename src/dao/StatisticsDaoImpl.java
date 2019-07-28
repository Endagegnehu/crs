package dao;

import entity.cr_file;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsDaoImpl implements StatisticsDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public int NumberOfTheft() 
    {
        int total=0;
        try
        {
        Session session = sessionFactory.getCurrentSession();
        
        List<cr_file> theCrimes = session.createQuery("from cr_file crime where crime.crime_name='theft'").list();
        
        for(cr_file crimes : theCrimes)
        {
            total++;
        }
        return total;
        }
        catch(Exception e)
        {
            total = 0;
            return total;
        }
    }

    @Override
    public int NumberOfRobbery() 
    {
        int total=0;
        try
        {
        Session session = sessionFactory.getCurrentSession();
        
        List<cr_file> theCrimes = session.createQuery("from cr_file crime where crime.crime_name='robbery'").list();
        
        for(cr_file crimes : theCrimes)
        {
            total++;
        }
        
        return total;
        }
        catch(Exception e)
        {
            total = 0;
            return total;
        }
    }

    @Override
    public int NumberOfAssault() 
    {
        int total=0;
        try
        {
        Session session = sessionFactory.getCurrentSession();
        
        List<cr_file> theCrimes = session.createQuery("from cr_file crime where crime.crime_name='assault'").list();
        
        for(cr_file crimes : theCrimes)
        {
            total++;
        }
        
        return total;
        }
        catch(Exception e)
        {
            total = 0;
            return total;
        }
    }

    @Override
    public int NumberOfAttemptedMurder() 
    {
        int total=0;
        try
        {
        Session session = sessionFactory.getCurrentSession();
        
        List<cr_file> theCrimes = session.createQuery("from cr_file crime where crime.crime_name='attempted_murder'").list();
        
        for(cr_file crimes : theCrimes)
        {
            total++;
        }
        
        return total;
        }
        catch(Exception e)
        {
            total = 0;
            return total;
        }
    }

    @Override
    public int NumberOfMurder() 
    {
        int total=0;
        try
        {
        Session session = sessionFactory.getCurrentSession();
        
        List<cr_file> theCrimes = session.createQuery("from cr_file crime where crime.crime_name='murder'").list();
        
        for(cr_file crimes : theCrimes)
        {
            total++;
        }
        
        return total;
        }
        catch(Exception e)
        {
            total = 0;
            return total;
        }
    }
    
}
