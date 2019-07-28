package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"name", "id"})
@RequestMapping("crfile")
public class CrfileController 
{
    @RequestMapping("page")
    public String page()
    {
        
        return "crfile";
    }
}
