package fr.uge.jee.servlet.rectanglesession;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RectangleController {
    @GetMapping("/rectangle")
    public String getRectangle(Model model){
        var rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(15);
        model.addAttribute("rectangle",rectangle);
        return "rectangle-form";
    }

    @PostMapping("/rectangle")
    public String processForm(@ModelAttribute("parameter") Rectangle parameter,
                              BindingResult result,
                              Model model, HttpSession httpSession){
        if (result.hasErrors()){
            return "error";
        }
        if (parameter.getWidth()<0 || parameter.getHeight()<0){
            return "error";
        }
        var area = parameter.area();
        model.addAttribute("area", area);

        var allArea = (List<Integer>) httpSession.getAttribute("areas");
        if(allArea == null){
            allArea = new ArrayList<>();
            httpSession.setAttribute("areas", allArea);
        }
        allArea.add(area);
        return "parameter-result";
    }
}
