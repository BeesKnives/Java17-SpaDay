package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){

        return "/user/add.html";
    }


    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        //form submission handling
        // if verify matches password, send to spa services, if not send back to add.html


        //check that they don't equal, add attribute error
        if(!user.getPassword().equals(verify)){
            model.addAttribute("error", "Error" );
            return "/user/add";

        }
        return "/serviceSelection";
    }

}
