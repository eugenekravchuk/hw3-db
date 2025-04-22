package com.example.govadmin.controller;

import com.example.govadmin.entity.Citizen;
import com.example.govadmin.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citizens")
public class CitizenController {
    @Autowired private CitizenRepository repo;

    @GetMapping
    public String list(Model m) {
        m.addAttribute("citizens", repo.findAll());
        return "citizens_list";
    }
    @GetMapping("/new")
    public String createForm(Model m) {
        m.addAttribute("citizen", new Citizen());
        return "citizen_form";
    }
    @PostMapping
    public String create(@ModelAttribute Citizen c) {
        repo.save(c);
        return "redirect:/citizens";
    }
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model m) {
        m.addAttribute("citizen", repo.findById(id).orElseThrow());
        return "citizen_form";
    }
    @PostMapping("/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Citizen c) {
        c.setCitizenID(id);
        repo.save(c);
        return "redirect:/citizens";
    }
    @GetMapping("/{id}/delete")
    public String deleteConfirm(@PathVariable Integer id, Model m) {
        m.addAttribute("entityId", id);
        m.addAttribute("entityType", "citizen");
        return "delete_confirm";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/citizens";
    }
}