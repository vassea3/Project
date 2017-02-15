package com.mycompany.service.intf;

import com.mycompany.model.HomeSlider;
import java.util.List;

public interface HomeSliderServiceIntf {

    public void update(HomeSlider homeSlide);

    public List<HomeSlider> findAll();

    public HomeSlider findById(int id);
}
