package dao;

import entity.case_file;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LawyerDaoImpl implements LawyerDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<case_file> listCasefile(int id) 
    {
        Session session = sessionFactory.getCurrentSession();
        List<case_file> thecasefile = session.createQuery("from case_file casefile where casefile.lawyer_id='"+id+"' and casefile.prosecutor_approved='approved'").list();
        return thecasefile;
    }
    
}
