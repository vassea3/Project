/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.intf;

import com.mycompany.model.HomeSlider;
import java.util.List;

/**
 *
 * @author Taniusha
 */
public interface HomeSliderServiceIntf {
    public void update(HomeSlider homeSlide);
public List<HomeSlider> findAll();
    public HomeSlider findById(int id);
}
