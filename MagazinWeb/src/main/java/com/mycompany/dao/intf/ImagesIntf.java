/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.intf;

import com.mycompany.model.Images;

/**
 *
 * @author Taniusha
 */
public interface ImagesIntf {

    public void save(Images image);

    public void update(Images image);

    public void delete(Images image);
}
