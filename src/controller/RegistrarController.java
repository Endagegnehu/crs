package controller;

import entity.case_file;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.JudgeService;
import service.ProsecutorService;
import service.RegistrarService;

@Controller
@SessionAttributes({"name","id"})
@RequestMapping("/registrar")
public class RegistrarController {
    
    @Autowired
    private RegistrarService registrarService;
    
    @Autowired
    private JudgeService judgeService;
    
    @RequestMapping("page")
    public String page(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "registrar";
    }
    
    @RequestMapping("/registrarprofile")
    public String UserProfile(@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        return "redirect:/profile/page";
    }
    
    @RequestMapping("/listcasefile")
    public String ListCaseFiles(@ModelAttribute("id") int id, Model model,@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        List<case_file> theCaseFile = registrarService.listCaseFile(id);
        if(theCaseFile.isEmpty())
        {
        model.addAttribute("casefilemsg", "No UnApproved Case Files");    
        }
        else
        {
            model.addAttribute("casefile", theCaseFile);
            List<String> judges = judgeService.GetJudges();
            model.addAttribute("judges", judges);
        }
        return "Registered-case-file-registrar";
    }
    
    @RequestMapping("/approvecasefile")
    public String ApproveCaseFiles(HttpServletRequest request, int casefileid,@ModelAttribute("name") String name)
    {
if(name.equals("null")) {
    		
    		return "index";
    	}
        String judgename = request.getParameter("assignedjudge");
        registrarService.ApproveCasefile(judgename,casefileid);
        return "redirect:/registrar/listcasefile";
    }
}
