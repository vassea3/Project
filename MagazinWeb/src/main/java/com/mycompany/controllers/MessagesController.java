package com.mycompany.controllers;

import com.mycompany.model.Messages;
import com.mycompany.service.intf.MessagesServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessagesController {

    @Autowired(required = true)
    @Qualifier(value = "messageService")
    MessagesServiceIntf messageServiceIntf;

    @RequestMapping("/cmsViewMessages")
    public String showMessages(Model model) {
        model.addAttribute("messages", this.messageServiceIntf.findAll());
        return "cmsViewMessages";
    }

    @RequestMapping("/delete/{id}")
    public String removeMessage(@PathVariable("id") int id) {
        Messages message = this.messageServiceIntf.findById(id);
        this.messageServiceIntf.delete(message);
        return "redirect:/cmsViewMessages";
    }
}
