/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.intf;

import com.mycompany.model.HomeSlider;
import java.util.List;

/**
 *
 * @author Taniusha
 */
public interface HomeSliderIntf {
        
    public void update(HomeSlider homeSlide);
    public List<HomeSlider> findAll();

    public HomeSlider findById(int id);
}
