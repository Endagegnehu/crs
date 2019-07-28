package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.Address;
import dao.CriminalProfileDao;
import dao.JobDao;
import dao.registerd_usersDao;
import dao.registered_crimes;
import entity.address;
import entity.crime_log;
import entity.criminal_profile;
import entity.job;
import entity.user_addres;
import entity.users;
import service.OfficerService;
import service.UsersService;


@Controller
@SessionAttributes({"name","job"})
public class PageController {
    
    @Autowired
    private OfficerService officerService;
    
    @Autowired
    private JobDao user_job;
    
    
    @GetMapping("/crimelogform")
    public String CrimeLogForm(Model model)
    {
//        List<String> offlist = officerService.getOfficers();
//        model.addAttribute("offlist", offlist);
        
        
    	List<job> offlist = (List<job>) user_job.getofficer();
    	 model.addAttribute("offlist", offlist);
    	 
        return "form-new-crime";
    }
    
    @GetMapping("/list")
    public String registerdcrim(Model model)
    {   
        return "Registered-crime";
    }
    
    @Autowired
    private registered_crimes crimelog;
    
    @GetMapping("/registerd")
    public String listCrime(Model crimeModel) {
    	List<crime_log> crimLog = crimelog.getRegisteredCrimes();
    	
    	crimeModel.addAttribute("crime", crimLog);
    	return "Registered-crime";
    }
    

    @GetMapping("/registerd_inv")
    public String listCrimeInvestigator(Model crimeModel) {
    	List<crime_log> crimLog = crimelog.getRegisteredCrimes();
    	
    	crimeModel.addAttribute("crime", crimLog);
    	return "Registered-crime-investigator";
    }
    
    
    @Autowired
    private CriminalProfileDao c_profile;
    
    @GetMapping("/registerd_suspect")
    public String listSuspect(Model crimeModel) {
    	List<criminal_profile> criminal_profile = c_profile.getRegisteredSuspects();
    	
    	crimeModel.addAttribute("suspect", criminal_profile);
    	return "Registered-suspect";
    }
    
    @Autowired
    private registerd_usersDao reg_users;
    
    @RequestMapping("/manage_users")
    public String listUsers(Model model) {
    	List<users> users = reg_users.getRegisterdUsers();    
    	model.addAttribute("users", users);
    	return "Registerde_users";
    }
    
    
    @GetMapping("/newUsers")
    public String newUser(Model themodel) {
    	users theUser = new users();
    	themodel.addAttribute("users", theUser);
    	return "form-new-user";
    }
    @Autowired
    private Address user_address;
    
    @GetMapping("/updateForm")
    public String updateUsers(@RequestParam("idusers") int theID,Model theModel) {
    	
    	int current_user = reg_users.getRegisterdUsersID(theID);
    	
    	
    	
    	address get_user_addres = user_address.getUserAddres(current_user);
    	
    	user_addres user_info = new user_addres(get_user_addres.getNew_users().getIdusers(), 
    											get_user_addres.getNew_users().getUser_name(),
    											get_user_addres.getNew_users().getPassword(),
    											get_user_addres.getNew_users().getFirst_name(),
    											get_user_addres.getNew_users().getEmail(),
    											get_user_addres.getNew_users().getLast_name(),
    											get_user_addres.getNew_users().getCreated_at(),
    											get_user_addres.getNew_users().getUpdated_at(),
    											get_user_addres.getIdaddres(),
    											get_user_addres.getHome_number(),
    											get_user_addres.getPhon(),
    											get_user_addres.getRegion(),
    											get_user_addres.getWoreda(),
    											get_user_addres.getKebele());
    	theModel.addAttribute("users", user_info);
    	return "form-new-user-update";
    }
    @RequestMapping("/newUsers")
    public String newUser() {
    	return "form-new-user";
    }
    
    @Autowired
    UsersService delete_user;
    
    @GetMapping("/delete")
    public String deleteUsers(@RequestParam("idusers") int theID){
    	
    	int current_user = reg_users.getRegisterdUsersID(theID);
    	delete_user.deleteUser(theID);
    	
    	return "redirect:/manage_users";
}
}