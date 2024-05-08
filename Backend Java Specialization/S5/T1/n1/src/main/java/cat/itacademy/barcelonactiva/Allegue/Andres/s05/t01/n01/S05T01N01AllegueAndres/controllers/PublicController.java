package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.Countries;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchAddRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class PublicController {
    @Autowired
    private BranchService branchService;

    @GetMapping("/documentation")
    public String documentation(){
        return "public_pages/documentation";
    }
    @GetMapping("/manager")
    public String manager(Model model) {
        model.addAttribute("branchAddRequest", new BranchAddRequest(null, null));
        model.addAttribute("countries", getAllCountryNames());
        model.addAttribute("branches", branchService.getAll());
        return "public_pages/manager";
    }
    @GetMapping("/contact")
    public String contact(){
        return "public_pages/contact";
    }

    public List<String> getAllCountryNames(){
        return Arrays.stream(Countries.values())
                .map(Countries::getCountry)
                .toList();
    }
}
