package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.registered_crimes;
import entity.crime_log;

@Controller
@RequestMapping("/investigator")
@SessionAttributes({"name","id"})
public class InvestigatorController 
{
	@Autowired
    private registered_crimes crimelog;
    
	@RequestMapping("/page")
    public String listCrimeInvestigator(@ModelAttribute("name") String name, Model crimeModel) {
if(name.equals("null")) {
    		
    		return "index";
    	}
		
    	List<crime_log> crimLog = crimelog.getRegisteredCrimes();
    	
    	crimeModel.addAttribute("crime", crimLog);
    	return "Registered-crime-investigator";
    }
    
	
//    public String Page(@SessionAttribute("name") String name)
//    {
//        return "Registered-crime-investigator";
//    }
    
    @RequestMapping("/investigatorprofile")
    public String Profile(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "redirect:/profile/page";
    }
    
    @RequestMapping("/crimelogview")
    public String CrimeLogView(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
}
        return "redirect:/crimelog/listcrimelog";
    }
    
    @RequestMapping("/casefileview")
    public String CaseFile(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "redirect:/casefile/casefileview";
    }
    
    @RequestMapping("/createcasefile")
    public String CreateCaseFile(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "form-case-file";
    }
}
