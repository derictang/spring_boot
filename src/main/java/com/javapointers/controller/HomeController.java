package com.javapointers.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    // Load home
    @RequestMapping("/")
    public String viewHome() {
        return "index";
    }
    
    // Posting the data
    @RequestMapping(value = "/javapointers", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("data", "data", new DataInput());
    }
 
    // Displaying the data
    @RequestMapping(value = "/javapointers", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("data")DataInput data, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "index";
        }
        model.addAttribute("name", data.getName());
        model.addAttribute("address", data.getAddress());
        model.addAttribute("id", data.getId());
        model.addAttribute("dob", data.getDob());
        model.addAttribute("age", data.getAge());
        return "table";
    }
    
}
