package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.Address;
import dao.CriminalProfileDao;
import dao.registered_crimes;
import entity.address;
import entity.cr_file;
import entity.crime_log;
import entity.criminal_profile;
import service.CrimeLogService;
import service.CriminalProfileService;
import service.JudgeService;
import service.OfficerService;

@Controller
@RequestMapping("officer")
@SessionAttributes({"name","id","job"})
public class OfficerController {
    
	@Autowired
    private CriminalProfileService criminalProfileService;
    
    @Autowired
    private Address address;
	
    @Autowired
    private OfficerService getofficer;
    
    @Autowired
    private registered_crimes crimelog;
    
    @RequestMapping("page")
    public String page(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "form-new-criminal";
    }
    
    @RequestMapping("/officerprofile")
    public String OfficerProfilePage(Model model,@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "redirect:/profile/page";
    }
    @RequestMapping("/crimelogform")
    public String CrimelogformPage(Model model,@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "redirect:/crimelog/page";
    }
    @RequestMapping("/criminalprofileform")
    public String OcriminalprofileformPage(Model model,@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "redirect:/criminalprofile/page";
    }
//    @RequestMapping("/listallcrfile")
//    public String listcrfilePage(Model model)
//    {
//        return "redirect:/judge/listallcrfile";
//    }
    
    @RequestMapping("/logout")
    public String logoutpage(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "redirect:/logout";
    }
    
    @PostMapping("/criminal_new_profile")
    public String RegisterSuspect(HttpServletRequest request, Model model,@ModelAttribute("name") String name)
    {
    	
if(name.equals("null")) {
    		
    		return "index";
    	}
    	
//        try
//        {
//        int suspectid = Integer.parseInt(request.getParameter("idsuspect"));
        String first_name = request.getParameter("first_name");
        String middle_name = request.getParameter("middle_name");
        String last_name = request.getParameter("last_name");
        String age = request.getParameter("age");
        String religion = request.getParameter("religion");
        String occupation = request.getParameter("occupation");
        String marital_status = request.getParameter("marital_status");
        String addiction = request.getParameter("addiction");
        String academic_level = request.getParameter("academic_level");
        
        String region = request.getParameter("region");
        String woreda = request.getParameter("woreda");
        String kebele = request.getParameter("kebele");
        String home_number = request.getParameter("home_number");
        String phone_number = request.getParameter("phone_number");
        
        criminal_profile criminalprofile = new criminal_profile(first_name, middle_name, last_name, age, religion, occupation, marital_status, addiction, academic_level);
       
        address address_new_criminal = new address(home_number, phone_number, region, woreda, kebele);
        
        criminalprofile.setAddress_new_criminal(address_new_criminal);
        
        address.saveAddres(address_new_criminal);
        
        criminalProfileService.SaveSuspect(criminalprofile);
        
        
        return "form-new-criminal";
        
//        return criminalProfileService.SaveSuspect(criminalprofile, address);
//        }
//        catch(Exception e)
//        {
//                model.addAttribute("criminal_profile_err", "Criminal ID Already Exist");
//                return "form-new-criminal";
//        }
    }
    
    @Autowired
    private CriminalProfileDao c_profile;
    
    @GetMapping("/registerd_suspect")
    public String listSuspect(Model crimeModel,@ModelAttribute("name") String name) {
    	
if(name.equals("null")) {
    		
    		return "index";
    	}
    	
    	List<criminal_profile> criminal_profile = c_profile.getRegisteredSuspects();
    	
    	crimeModel.addAttribute("suspect", criminal_profile);
    	return "Registered-suspect";
    }  
    
    @Autowired
    private JudgeService judgeService;
    
    @RequestMapping("/listallcrfiles")
    public String ListallCrfiles(Model model,@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        List<cr_file> thecrFiles = judgeService.listallcr_files();
        model.addAttribute("crfiles", thecrFiles);
        return "Registered-cr_files-officer";
    }
    
    @RequestMapping("/saveCrimeLog")
    public String saveCrimeLog(Model model,@ModelAttribute("name") String name) {
if(name.equals("null")) {
    		
    		return "index";
    	}
    	List<String> investigator = getofficer.getOfficers();
    	model.addAttribute("offlist", investigator);
    	return "form-new-crime";
    }
    
    @Autowired
    private CrimeLogService crimeLogService;
    
    @PostMapping("/savecrimelog")
    public String SaveCrimeLog(HttpServletRequest request,@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
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
        
        return "form-new-criminal";
    }
    
    @GetMapping("/registerd")
    public String listCrime(Model crimeModel,@ModelAttribute("name") String name) {
if(name.equals("null")) {
    		
    		return "index";
    	}
    	List<crime_log> crimLog = crimelog.getRegisteredCrimes();
    	
    	crimeModel.addAttribute("crime", crimLog);
    	return "Registered-crime-officer";
    }
    
}
