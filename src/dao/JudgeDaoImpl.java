package dao;

import entity.case_file;
import entity.cr_file;
import entity.job;
import entity.users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JudgeDaoImpl implements JudgeDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<String> GetJudges() 
    {
        List<String> judgelist = new ArrayList();
        ArrayList<Integer> idList = new ArrayList(); 
        
        Session currentsession = sessionFactory.getCurrentSession();
        
        List<job> judgesList = currentsession.createQuery("from job off where off.name='judge'", job.class).getResultList();
        
        for(job tempjob : judgesList)
        {
        	judgelist.add(tempjob.getUsers_idusers().getUser_name());
        }
        
//        for(Integer num : idList)
//        {
//            List<users> userList = currentsession.createQuery("from users off where off.idusers='"+num+"'", users.class).getResultList();
//            
//            for(users tempuser : userList)
//            {
//                judgelist.add(tempuser.getUser_name());
//            }
//        }
    return judgelist;
    }

    @Override
    public List<case_file> getcasefiles(int id) 
    {
        Session session = sessionFactory.getCurrentSession();
        List<case_file> thecasefile = session.createQuery("from case_file casefiles where casefiles.judge_id='"+id+"'").list();
        return thecasefile;
    }

    @Override
    public List<cr_file> creatCrfiles(int investigator_id, int casefile_id, String defendant_name, String crime_name, String dateof_crime, String date_filed_on, String dateof_imprisonment, String sentence) 
    {
        Session session = sessionFactory.getCurrentSession();
        
        cr_file theCrfile = new cr_file(defendant_name, crime_name, investigator_id, dateof_imprisonment, dateof_crime, date_filed_on, casefile_id, sentence);
        
        session.save(theCrfile);
        
        List<cr_file> theCrfiles = session.createQuery("from cr_file").list();
        
        return theCrfiles;
    }

    @Override
    public List<cr_file> listallcrfiles() 
    {
        Session session = sessionFactory.getCurrentSession();
        
        List<cr_file> thecrFiles = session.createQuery("from cr_file").list();
        
        return thecrFiles;
    }
    
}
