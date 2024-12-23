package org.example.hello_spring.controllers;

import jakarta.validation.Valid;

import org.example.hello_spring.data.EventCategoryRepository;
import org.example.hello_spring.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("categories")
public class EventCategoryController {
    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("category", eventCategoryRepository.findAll());
        return "categories/index";
    }

    @GetMapping("createC")
    public String renderCreateCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute("category", new EventCategory());  // Add a name for the attribute
        return "categories/createC";
    }

    @PostMapping("createC")
    public String createCategory(@ModelAttribute @Valid EventCategory newCategory, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            return "categories/createC";
        }
        eventCategoryRepository.save(newCategory);
        return "redirect:/categories";
    }
}
