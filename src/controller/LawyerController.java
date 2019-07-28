package controller;

import entity.case_file;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.LawyerService;

@Controller
@SessionAttributes({"name","id"})
@RequestMapping("/lawyer")
public class LawyerController 
{
  @Autowired
  private LawyerService lawyerService;
  
  @RequestMapping("/page")
  public String page(@ModelAttribute("name") String name)
  {
	  if(name.equals("null")) {
  		
  		return "index";
  	}
      return "lawyer";
  }
  
  @RequestMapping("/lawyerprofile")
  public String UserProfile(@ModelAttribute("name") String name)
  {
	  if(name.equals("null")) {
  		
  		return "index";
  	}
      return "redirect:/profile/page";
  }
  
  @RequestMapping("/listcasefile")
  public String ListcaseFile(@ModelAttribute("name") String name,@ModelAttribute("id") int id,Model model)
  {
	  if(name.equals("null")) {
  		
  		return "index";
  	}
      List<case_file> thecasefile = lawyerService.listCaasefile(id);
      if(thecasefile.isEmpty())
      {
          model.addAttribute("casefilemsg", "No Case File Created For You");
      }
      else
      {
          model.addAttribute("casefile", thecasefile);
      }
      return "Registered-case-files-lawyer";
  }
    
}
