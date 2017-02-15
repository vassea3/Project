/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.intf;

import com.mycompany.model.Messages;
import java.util.List;

/**
 *
 * @author Taniusha
 */
public interface MessagesServiceIntf {
    public void save(Messages message);
    public void delete(Messages message);
    public Messages findById(int id);
    public List<Messages> findAll();
}
