package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BaseController {
    @GetMapping("/login")
    public String login(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("login_modal_pressed", true);
        return "redirect:/";
    }
    @GetMapping("/register")
    public String register(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("register_modal_pressed", true);
        return "redirect:/";
    }
}
