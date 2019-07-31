package controller;

import dao.LogInDao;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"name", "id"})
public class LogInController {
    
    @Autowired
    private LogInDao logInDao;
    
    @PostMapping("/login")
//    @GetMapping("/login")
    public String LogIn(@RequestParam(name = "username") String username, @RequestParam(name = "password")
    		String password,Model model,HttpSession httpSession)
    {
        return logInDao.NextPage(username, password,model,httpSession);
    }
}

//public class LogInController{
//	
//	@Autowired
//	private LogInDao loginDao;
//	
//	@GetMapping("/login")
//	public String LogIn(@SessionAttribute(name = "username") String username, @RequestParam(name = "password")
//	String password,Model model,HttpSession httpSession) {
//		
//		httpSession.setAttribute("username", username);
//		httpSession.setAttribute("password", password);
//		
//		System.out.println(httpSession.getAttribute(username));
//		
//		return loginDao.loginPage(httpSession);
//	}
//	
	
	
//}




