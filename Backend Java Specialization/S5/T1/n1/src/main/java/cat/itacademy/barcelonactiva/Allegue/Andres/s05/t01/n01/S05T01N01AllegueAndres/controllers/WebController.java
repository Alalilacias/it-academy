package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    private final MessageSource messageSource;

    public WebController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        String greeting = messageSource.getMessage("messages.greeting", null, LocaleContextHolder.getLocale());
        String body1 = messageSource.getMessage("messages.body1", null, LocaleContextHolder.getLocale());
        String body2 = messageSource.getMessage("messages.body2", null, LocaleContextHolder.getLocale());

        model.addAttribute("greeting", greeting);
        model.addAttribute("body1", body1);
        model.addAttribute("body2", body2);
        return "index";
    }
    public String showDocumentation(Model model){
        return "documentation";
    }
}
