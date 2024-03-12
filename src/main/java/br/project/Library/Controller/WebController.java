package br.project.Library.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class WebController {

    @GetMapping("/index")
    public String firstPage(){
        return "index";
    }
}
