package controller;

import entity.case_file;
import entity.cr_file;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.JudgeService;

@Controller
@RequestMapping("/judge")
@SessionAttributes({"name","id"})
public class JudgeController 
{
   @Autowired
   private JudgeService judgeService;
    
   @RequestMapping("/page")
   public String page(@ModelAttribute("name") String name)
   {
	   if(name.equals("null")) {
   		
   		return "index";
   	}
       return "judge";
   }
   
   @RequestMapping("/judjeprofile")
   public String UserProfile(@ModelAttribute("name") String name)
   {
	   if(name.equals("null")) {
   		
   		return "index";
   	}
       return "redirect:/profile/page";
   }
   
   @RequestMapping("/listcasefile")
   public String caseFiles(@ModelAttribute("name") String name,@ModelAttribute("id") int id, Model model)
   {
	   if(name.equals("null")) {
   		
   		return "index";
   	}
       List<case_file> casefiles = judgeService.getCasefiles(id);
       model.addAttribute("casefile", casefiles);
       return "Registered-case-file-judge";
   }
   
   @PostMapping("/judgelistcrfile")
   public String creatCrfiles(@ModelAttribute("name") String name,HttpServletRequest request, Model model)
   {
	   if(name.equals("null")) {
   		
   		return "index";
   	}
       String defendant_name,crime_name,dateof_crime,date_filed_on,dateof_imprisonment,sentence;
       int investigator_id,casefile_id;
       
       investigator_id = Integer.parseInt(request.getParameter("investigator_id"));
       casefile_id = Integer.parseInt(request.getParameter("casefile_id"));
       defendant_name = request.getParameter("defendant_name");
       crime_name = request.getParameter("crime_name");
       dateof_crime = request.getParameter("dateof_crime");
       date_filed_on = request.getParameter("date_filed_on");
       dateof_imprisonment = request.getParameter("dateof_imprisonment");
       sentence = request.getParameter("sentence");
       
       System.out.println(sentence);
       
       List<cr_file> crfiles = judgeService.creatCrfiles(investigator_id, casefile_id, defendant_name, crime_name, dateof_crime, date_filed_on, dateof_imprisonment, sentence);
       
       model.addAttribute("crfiles", crfiles);
       
       return "Registered-cr_files";
   }
   @RequestMapping("/listallcrfile")
   public String ListallCrfiles(Model model,@ModelAttribute("name") String name)
   {
	   if(name.equals("null")) {
   		
   		return "index";
   	}
       List<cr_file> thecrFiles = judgeService.listallcr_files();
       model.addAttribute("crfiles", thecrFiles);
       return "Registered-cr_files";
   }
}
