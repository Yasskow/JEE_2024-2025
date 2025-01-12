package fr.uge.jee.springmvc.pokematch;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {

    private final PokematchService pokematchService;

    @Autowired
    public AppController(PokematchService pokematchService) {
        this.pokematchService = pokematchService;
    }

    @GetMapping("/pokemon")
    public String formular(@ModelAttribute("User") @Valid User user, Model model, BindingResult result){
        return "home-form";
    }

    @PostMapping("/pokemon")
    public String createStudent(@Valid @ModelAttribute("User") User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "home-form";
        }

        var fetish = pokematchService.findFetish(user);
        var mostFetish = pokematchService.getMostFetich();
        model.addAttribute("fetish", fetish);
        model.addAttribute("listOfMostFetish", mostFetish);
        return "home-form";
    }
}
