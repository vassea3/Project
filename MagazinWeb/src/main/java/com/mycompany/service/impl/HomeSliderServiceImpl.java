package com.mycompany.service.impl;

import com.mycompany.dao.intf.ContactPageIntf;
import com.mycompany.dao.intf.HomeSliderIntf;
import com.mycompany.model.HomeSlider;
import com.mycompany.service.intf.HomeSliderServiceIntf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("homeSlideService")
public class HomeSliderServiceImpl implements HomeSliderServiceIntf {

    @Autowired
    private HomeSliderIntf homeSliderIntf;

    public void setHomeSliderIntf(HomeSliderIntf homeSliderIntf) {
        this.homeSliderIntf = homeSliderIntf;
    }

    @Override
    @Transactional
    public void update(HomeSlider homeSlide) {
        this.homeSliderIntf.update(homeSlide);
    }

    @Override
    @Transactional
    public HomeSlider findById(int id) {
        return this.homeSliderIntf.findById(id);
    }

    @Override
    @Transactional
    public List<HomeSlider> findAll() {
        return this.homeSliderIntf.findAll();
    }

}
