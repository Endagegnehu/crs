package dao;

import entity.job;
import entity.users;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Repository
public class LogInDaoImpl implements LogInDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public String NextPage(String name, String password,Model model) 
    {
        int id = 0;
        String UserJob = null,page = null;
        Session session = sessionFactory.getCurrentSession();
        
        try
        {
            @SuppressWarnings("unchecked")
			List<users> theuser = session.createQuery("from users user where user.user_name='"+name+"' AND user.password='"+password+"'").list();
            if(theuser != null)
            {
                for(users tempuser : theuser)
                {
                    id = tempuser.getIdusers();
                }
                model.addAttribute("id", id);
            }
			List<job> userjob = session.createQuery("from job user where user.users_idusers='"+id+"'").list();
            if(userjob != null)
            {
                model.addAttribute("name",name);
                for(job jobs : userjob)
                {
                    UserJob = jobs.getName();
                }
            }
            switch(UserJob)
            {
                case "officer":
               
                	model.addAttribute("job", "Police officer");
                	page = "redirect:/officer/page";
                        break;
                case "investigator":
                	model.addAttribute("job", "Investigator");
                    page = "redirect:/investigator/page";
                    break;
                case "prosecutor":
                	
                	model.addAttribute("job", "Prosecutor");
                    page = "redirect:/prosecutor/listcasefile";
                    break;
                case "judge":
                	
                	model.addAttribute("job", "Judge");
                	page = "redirect:/judge/listcasefile";
                    break;
                case "lawyer":
                	
                	model.addAttribute("job", "Lawyer");
                	page = "redirect:/lawyer/listcasefile";
                    break;
                case "registrar_office":
                    page = "redirect:/registrar/listcasefile";
                    break;
                case "admin":
                    page = "redirect:/manage_users";
                    break;
                default:
                    page = "index";
                    break;
            }
            return page;
        }
        catch(Exception e)
        {
            model.addAttribute("msg", "Incorrect Entry");
            return "index";
        }
        
    }
    
}
