package com.example.govadmin.controller;

import com.example.govadmin.entity.Complaint;
import com.example.govadmin.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/complaints")
public class ComplaintController {
    @Autowired private ComplaintRepository repo;

    @GetMapping
    public String list(Model m) {
        m.addAttribute("complaints", repo.findAll());
        return "complaints_list";
    }
    @GetMapping("/new")
    public String createForm(Model m) {
        m.addAttribute("complaint", new Complaint());
        return "complaint_form";
    }
    @PostMapping
    public String create(@ModelAttribute Complaint c) {
        repo.save(c);
        return "redirect:/complaints";
    }
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model m) {
        m.addAttribute("complaint", repo.findById(id).orElseThrow());
        return "complaint_form";
    }
    @PostMapping("/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Complaint c) {
        c.setComplaintID(id);
        repo.save(c);
        return "redirect:/complaints";
    }
    @GetMapping("/{id}/delete")
    public String deleteConfirm(@PathVariable Integer id, Model m) {
        m.addAttribute("entityId", id);
        m.addAttribute("entityType", "complaint");
        return "delete_confirm";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/complaints";
    }
}