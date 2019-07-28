package controller;

import entity.address;
import entity.crime_log;
import entity.job;
import entity.users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.Address;
import dao.JobDao;
import dao.UsersDao;
import service.CrimeLogService;
import service.OfficerService;
import service.UsersService;

@Controller
public class UserController {
    
    @Autowired
    private CrimeLogService crimeLogService;
    
    @Autowired
    private UsersService usersService;
//    private UsersDao UserController;
    @Autowired
    private Address address;
    
    @Autowired
    private JobDao job_user;
    
    
    @PostMapping("/savecrimelog")
    public String SaveCrimeLog(HttpServletRequest request)
    {
        IdConverter2 idConverter = new IdConverter2();
        int id =Integer.parseInt(request.getParameter("crimeid"));
        String crimetype = request.getParameter("crimetype");
        String occureddate = request.getParameter("crimeoccuredDate");
        String registereddate = request.getParameter("crimeregistereddate");
        String defendantname = request.getParameter("defendantname");
        String plaintiffname = request.getParameter("plaintiffname");
        String assignedofficer = request.getParameter("assignedofficer");
        String crimedescription = request.getParameter("crimedescription");
        
//        int id_user = Integer.parseInt(assignedofficer);
        
//        int officerid = idConverter.Convert(assignedofficer);
        
        crime_log crimelog = new crime_log(crimetype, occureddate, registereddate, defendantname, plaintiffname, assignedofficer, crimedescription);
        
        crimeLogService.saveCrimeLog(crimelog);
        
        return "index";
    }
    @PostMapping("/saveUsers")
    public String SaveUsers(HttpServletRequest request) {
    	
    	Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
    	
    	String firstName = request.getParameter("first_name");
    	String lastName = request.getParameter("last_name");
    	String userName = request.getParameter("user_name");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");
    	
    	String houseNumber = request.getParameter("home_number");
    	String phoneNumber = request.getParameter("phon");
    	String region = request.getParameter("region");
    	String woreda = request.getParameter("woreda");
    	String keble = request.getParameter("kebele");
   
    	String job = request.getParameter("job");
    	
//    	String role = request.getParameter("role");
    	
    	
    	job user_job = new job(job);
    	
    	users users_form_page = new users(userName,password,email,firstName,lastName,strDate,strDate);
    	
    	address address_user = new address(houseNumber, phoneNumber, region, woreda, keble);
    	
    	user_job.setUsers_idusers(users_form_page);
    	
    	users_form_page.setAddress_new(address_user);
    	
    	address.saveAddres(address_user);
    	
    	job_user.saveJob(user_job);
    	
//    	usersService.saveNewUser(users_form_page);
    	
    	
    	return "redirect:/manage_users";
    }
    
    @PostMapping("/update")
    public String SaveUsersUpdate(HttpServletRequest request) {
    	
    	Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
    	
    	String firstName = request.getParameter("first_name");
    	String lastName = request.getParameter("last_name");
    	String userName = request.getParameter("user_name");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");
    	
    	String houseNumber = request.getParameter("home_number");
    	String phoneNumber = request.getParameter("phon");
    	String region = request.getParameter("region");
    	String woreda = request.getParameter("woreda");
    	String keble = request.getParameter("kebele");
    	
    	int id_users = Integer.parseInt(request.getParameter("idusers"));
    	int id_address = Integer.parseInt(request.getParameter("idaddres"));
    	
    	
    	System.out.println(id_users+" "+id_address);
    	users users_form_page = new users(userName,password,email,firstName,lastName,strDate,strDate);
    	
    	address address_user = new address(houseNumber, phoneNumber, region, woreda, keble);
    	
    	
    	users_form_page.setAddress_new(address_user);
    	
    	address.saveAddresUpdate(address_user,id_address);
    	
    	usersService.saveNewUserUpdate(users_form_page,id_users);
    	
    	
    	return "redirect:/manage_users";
    }
    

}
