package dao;

import controller.IdConverter;
import entity.case_file;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrarDaoImpl implements RegistrarDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private CaseFileDao get_id;
    
    @Override
    public List<case_file> listCaseFile(int id) 
    {
        Session session = sessionFactory.getCurrentSession();
        List<case_file> theCaseFile = session.createQuery("from case_file casefile where casefile.registrar_approved='not approved'").list();
        return theCaseFile;
    }

    @Override
    public void ApprovecaseFile(String name,int id) 
    {
        IdConverter idConverter = new IdConverter();
        Session session = sessionFactory.getCurrentSession();
        
        case_file casefile = session.get(case_file.class, id);
        
        int judgeid = get_id.getID(name);
        casefile.setJudge_id(judgeid);
        casefile.setRegistrar_approved("approved");
    }
       
}
