package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WebController {
    @GetMapping("/documentation")
    public String documentation(Model model){
        model.addAttribute("pageTitle", "Documentation | Isle");
        return "public_pages/documentation";
    }
}
