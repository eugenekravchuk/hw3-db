package com.example.govadmin.controller;

import com.example.govadmin.entity.Property;
import com.example.govadmin.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/properties")
public class PropertyController {
    @Autowired private PropertyRepository repo;

    @GetMapping
    public String list(Model m) {
        m.addAttribute("properties", repo.findAll());
        return "properties_list";
    }
    @GetMapping("/new")
    public String createForm(Model m) {
        m.addAttribute("property", new Property());
        return "property_form";
    }
    @PostMapping
    public String create(@ModelAttribute Property p) {
        repo.save(p);
        return "redirect:/properties";
    }
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model m) {
        m.addAttribute("property", repo.findById(id).orElseThrow());
        return "property_form";
    }
    @PostMapping("/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Property p) {
        p.setPropertyID(id);
        repo.save(p);
        return "redirect:/properties";
    }
    @GetMapping("/{id}/delete")
    public String deleteConfirm(@PathVariable Integer id, Model m) {
        m.addAttribute("entityId", id);
        m.addAttribute("entityType", "property");
        return "delete_confirm";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/properties";
    }
}
