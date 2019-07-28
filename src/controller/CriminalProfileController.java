package controller;

import entity.address;
import entity.criminal_profile;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.Address;
import service.CriminalProfileService;

@Controller
@SessionAttributes({"name", "id"})
@RequestMapping("criminalprofile")
public class CriminalProfileController {
    
    @Autowired
    private CriminalProfileService criminalProfileService;
    
    @Autowired
    private Address address;
    
    @RequestMapping("/page")
    public String page()
    {
        return "form-new-criminal";
    }
    
    @PostMapping("/criminal_new_profile")
    public String RegisterSuspect(@ModelAttribute("name") String name,HttpServletRequest request, Model model)
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
}
