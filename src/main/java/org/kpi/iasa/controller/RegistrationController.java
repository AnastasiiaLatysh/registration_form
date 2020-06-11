package org.kpi.iasa.controller;

import org.kpi.iasa.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String fetchRegistrationPage(User user, Model model)
    {
        System.out.println("GET registration is called");
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult bindingResult, ModelMap model) {
        System.out.println("POST registration is called");
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "registration";
        }
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("birthday", user.getBirthday());
        model.addAttribute("phoneNumber", user.getPhoneNumber());
        return "registered_user";
    }
}
