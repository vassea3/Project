/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.model.ContactPage;
import com.mycompany.model.Messages;
import com.mycompany.service.intf.ContactPageServiceIntf;
import com.mycompany.service.intf.MessagesServiceIntf;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Taniusha
 */
@Controller

public class ContactPageController {

    @Autowired(required = true)
    @Qualifier(value = "contactService")
    ContactPageServiceIntf contPageServiceIntf;

    @Autowired(required = true)
    @Qualifier(value = "messageService")
    MessagesServiceIntf messageServiceIntf;

    @RequestMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("messages", new Messages());
        //model.addAttribute("contact", this.contPageServiceIntf.findById(1));
        return "contact";
    }

    @RequestMapping("/cmsContactPage")
    public String showCmsContactPage(Model model) {
        model.addAttribute("contactPage", this.contPageServiceIntf.findById(1));
        return "cmsContactPage";
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST)
    public String updateContacts(@ModelAttribute ContactPage contactPage, Model model) {
        this.contPageServiceIntf.update(contactPage);
        return "redirect:/cmsContactPage?success=true";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendMessage(@ModelAttribute Messages messages, BindingResult result, SessionStatus status, Model model) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        DateFormat tf = new SimpleDateFormat("HH:mm");
        Date dateobj = new Date();
        Date dateobj1 = new Date();
        String data=df.format(dateobj);
        String ora=tf.format(dateobj1);
        messages.setData(data);
        messages.setOra(ora);
        this.messageServiceIntf.save(messages);
        return "redirect:/contact?success=true";
    }
}
