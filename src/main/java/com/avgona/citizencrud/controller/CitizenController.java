package com.avgona.citizencrud.controller;

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

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get citizens from db
        List<Citizen> citizens = citizenService.findAll();

        // add to the spring model
        model.addAttribute("citizensAttr", citizens);

        return "list-citizens";
    }

    @GetMapping("/show-form-add")
    public String showForm(Model model) {

        // create model attribute to bind form data
        Citizen citizen = new Citizen();

        model.addAttribute("citizenAttr", citizen);

        return "show-form";
    }

    @GetMapping("/show-form-update")
    public String showFormUpdate(@RequestParam("citizenId") int id,
                                 Model model) {

        // get the citizen from the service
        Citizen citizen = citizenService.findById(id);


        // set citizen as a model attribute to pre-populate the form
        model.addAttribute("citizenAttr", citizen);

        // send over to our form
        return "show-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("citizen") Citizen citizen) {

        // save the citizen
        citizenService.save(citizen);

        // use a redirect to prevent duplicate submissions
        return "redirect:/citizens/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("citizenId") int id) {

        // delete citizen by given id
        citizenService.deleteById(id);

        return "redirect:/citizens/list";

    }


    @GetMapping("/search")
    public String search(@RequestParam("name") String name,
                         Model theModel) {
        // get citizens by LAST NAME
        List<Citizen> citizens = citizenService.searchBy(name);

        // set searched list of citizens
        theModel.addAttribute("citizensAttr", citizens);

        return "list-citizens";

    }
}