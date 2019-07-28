package controller;

import entity.case_file;
import entity.crime_log;
import entity.job;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.CaseFileService;

@Controller
@RequestMapping("/casefile")
@SessionAttributes({"name","id"})
public class CaseFileController 
{
    @Autowired
    private CaseFileService caseFileService;
    
    @RequestMapping("/page")
    public String Page(@ModelAttribute("name") String name)
    {
    	if(name.equals("null")) {
    		
    		return "index";
    	}
    	
        return "case_file";
    }
    
    @RequestMapping("/createcasefile")
    public String CreateCaseFile(@ModelAttribute("name") String name,int crimelogid,Model model)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
    	
        List<crime_log> theLog = caseFileService.getCrimelog(crimelogid);
        List<String> theLawyer = caseFileService.getLawyer();
        List<String> theProsecutor = caseFileService.getProsecutor();
        
        System.out.println(theLog);
        System.out.println(theLawyer);
        System.out.println(theProsecutor);
        
        
        model.addAttribute("lawyer", theLawyer);
        model.addAttribute("prosecutor", theProsecutor);
        model.addAttribute("log", theLog);
        
        return "form-case-file";
    }
    
    @RequestMapping("/savecasefile")
    public String SaveCaseFile(@ModelAttribute("name") String name,HttpServletRequest request,Model model)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        IdConverter idConverter = new IdConverter();
        String typeof_crime,dateof_crime,crime_tip_date,investigation_end_date,
               prosecutor = null,suspect_name,lawyer = null,prosecutor_approved,
               registrar_approved,short_sumary;
        int prosecutorid,lawyerid,log_file_id,investigator_id;
        
        lawyer = request.getParameter("lawyer");
        prosecutor = request.getParameter("prosecutor");
        
        System.out.println(prosecutor);
        
        lawyerid = caseFileService.getParameter(lawyer);
        prosecutorid = caseFileService.getParameter(prosecutor);
        
        
        
        typeof_crime = request.getParameter("typeof_crime");
        dateof_crime = request.getParameter("dateof_crime");
        crime_tip_date = request.getParameter("crime_tip_date");
        log_file_id = Integer.parseInt(request.getParameter("log_file_id"));
        investigation_end_date = request.getParameter("investigation_end_date");
        investigator_id = Integer.parseInt(request.getParameter("investigator_id"));
        suspect_name = request.getParameter("suspect_name");
        short_sumary = request.getParameter("short_sumary");
        prosecutor_approved = request.getParameter("prosecutor_approved");
        registrar_approved = request.getParameter("registrar_approved");
        
        System.out.println(suspect_name);
        
        return caseFileService.createCasefile(typeof_crime,dateof_crime,crime_tip_date,
                                        investigation_end_date,suspect_name,
                                        prosecutor_approved,registrar_approved,short_sumary,
                                        prosecutorid,lawyerid,log_file_id,investigator_id);
      
    }
    
    @RequestMapping("/casefileview")
    public String ListCaseFile(@ModelAttribute("name") String name,Model model,int id)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        List<case_file> casefile = caseFileService.ListCaseFile(id);
        model.addAttribute("casefile", casefile);
        return "list_case_file";
    }
}
