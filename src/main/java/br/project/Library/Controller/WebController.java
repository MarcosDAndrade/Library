package br.project.Library.Controller;


import br.project.Library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }
}
