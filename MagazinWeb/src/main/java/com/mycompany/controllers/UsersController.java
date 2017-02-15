package com.mycompany.controllers;

import com.mycompany.model.Users;
import com.mycompany.service.intf.UsersServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {

    @Autowired(required = true)
    @Qualifier(value = "usersService")
    UsersServiceIntf usersServiceIntf;

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(@ModelAttribute Users users, Model model) {
        if (!usersServiceIntf.findAllUsernames().contains(users.getUsername())) {
            System.out.println("bun");
            if (users.getId() == 0) {

                this.usersServiceIntf.save(users);
            } else {

                this.usersServiceIntf.save(users);
            }
        } else {
            System.out.println("rau");
        }
        return "redirect:/login?success=true";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        model.addAttribute(new Users());
        return "login";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(@ModelAttribute Users users, Model model) {
        Users user = new Users();
        String username = users.getUsername();
        user = this.usersServiceIntf.findByUsername(username);
        String page = "redirect:/home";
        if (user != null) {
            if (user.getPassword().equals(users.getPassword())) {
                page = "cmsHome";
            } else {
                System.out.println("password or username is incorect");
            }
        } else {
            System.out.println("password or username is incorect");
        }
        return page;

    }
}
