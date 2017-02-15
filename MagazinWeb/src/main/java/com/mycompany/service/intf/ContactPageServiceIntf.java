/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.intf;

import com.mycompany.model.ContactPage;

/**
 *
 * @author Taniusha
 */
public interface ContactPageServiceIntf {
    public void update(ContactPage contPage);
    public ContactPage findById(int id);
}
