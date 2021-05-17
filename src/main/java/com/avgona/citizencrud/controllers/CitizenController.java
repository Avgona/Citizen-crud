package com.avgona.citizencrud.controllers;

import com.avgona.citizencrud.entity.Citizen;
import com.avgona.citizencrud.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public String index(Model model) {
        List<Citizen> citizens = citizenService.findAll();

        model.addAttribute("citizens", citizens);

        return "index";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("citizen", new Citizen());

        return "form";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") long id, Model model) {
        Citizen citizen = citizenService.findById(id);

        model.addAttribute("citizen", citizen);

        return "form";
    }

    @GetMapping("/details")
    public String viewDetails(@RequestParam("id") long id, Model model){
        Citizen citizen = citizenService.findById(id);

        model.addAttribute("citizen", citizen);

        return "details";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("citizen") Citizen citizen) {
        System.out.println(citizen.getForeignCitizenship());
        citizenService.save(citizen);

        return "redirect:/citizens";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        citizenService.deleteById(id);

        return "redirect:/citizens";
    }


    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Citizen> citizens = citizenService.searchBy(name);

        model.addAttribute("citizens", citizens);

        return "index";
    }
}