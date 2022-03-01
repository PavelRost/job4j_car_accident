package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccidentControl {

    private final AccidentService accidentService;

    public AccidentControl(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidentService.getAllAccidentTypeHbn());
        model.addAttribute("rules", accidentService.getAllRulesHbn());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidentService.addHbn(accident, ids);
        return "redirect:/";
    }

    @GetMapping("/updateGet")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.findByIdHbn(id));
        return "accident/update";
    }

    @PostMapping("/updatePost")
    public String update(@RequestParam("id") int id, @ModelAttribute Accident accident) {
        accidentService.updateAccidentHbn(id, accident);
        return "redirect:/";
    }
}
