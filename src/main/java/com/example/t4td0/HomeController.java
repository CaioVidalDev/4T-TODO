package com.example.t4td0;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
;

@Controller
public class HomeController {

    
    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/projeto-tarefas/index.html");

        return mv;

    }

} 




    

