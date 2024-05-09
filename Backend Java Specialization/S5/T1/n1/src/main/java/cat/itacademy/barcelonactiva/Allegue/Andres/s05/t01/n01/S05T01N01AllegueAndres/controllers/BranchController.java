package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.controllers;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchAddRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces.BranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @PostMapping("/add")
    public ModelAndView addBranch (@Valid@ModelAttribute BranchAddRequest branchAddRequest, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("branchAddRequest", new BranchAddRequest(null, null));
            model.addAttribute("addError", true);
            return new ModelAndView("redirect/manager",model.asMap());

        }  else {
            branchService.add(branchAddRequest);
            return new ModelAndView("redirect:/manager", model.asMap());
        }
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteBranch(@PathVariable("id") int id, Model model){
        boolean isDeleted = branchService.delete(id);
        if (!isDeleted) {
            model.addAttribute("deleteError", true);
        }
        return new ModelAndView("redirect:/manager", model.asMap());
    }
}