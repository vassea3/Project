package com.mycompany.dao.intf;

import com.mycompany.model.HomeSlider;
import java.util.List;

public interface HomeSliderIntf {

    public void update(HomeSlider homeSlide);

    public List<HomeSlider> findAll();

    public HomeSlider findById(int id);
}
