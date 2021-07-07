package com.saltech.testwebatriowebapp.controllers;


import com.saltech.testwebatriowebapp.models.Personne;
import com.saltech.testwebatriowebapp.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("/")
    public String home(Model model){

        Iterable<Personne> lisEmployees = personneService.getPersonnes();
        model.addAttribute("personnes", lisEmployees);
        return "home";
    }

    @GetMapping("/createPersonne")
    public String createEmploye(Model model){
        Personne personne = new Personne();
        model.addAttribute("personne", personne);
        return "formSavePersonne";
    }

    @PostMapping("/savePersonne")
    public ModelAndView savePersonne(@ModelAttribute Personne personne) throws Exception {
        if(personne.getId() != null) {
            //not handling update personne
        }
        personneService.savePersonne(personne);
        return new ModelAndView("redirect:/");
    }

}
