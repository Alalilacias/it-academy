package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PublicController {
    @GetMapping("/documentation")
    public String documentation(){
        return "public_pages/documentation";
    }
    @GetMapping("/manager")
    public String manager(){
        return "public_pages/manager";
    }
    @GetMapping("/contact")
    public String contact(){
        return "public_pages/contact";
    }
}
