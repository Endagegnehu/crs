package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StatisticsService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController 
{
    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/page")
    public String Page(Model model)
    {        
        model.addAttribute("theft",statisticsService.NumberOfTheft());
        model.addAttribute("robbery",statisticsService.NumberOfRobbery());
        model.addAttribute("assault",statisticsService.NumberOfAssault());
        model.addAttribute("attempted_murder", statisticsService.NumberOfAttemptedMurder());
        model.addAttribute("murder", statisticsService.NumberOfMurder());
        //int num = statisticsService.NumberOfMurder();
        //model.addAttribute("aa", num);
        
        return "statistics";
    }
    
}
