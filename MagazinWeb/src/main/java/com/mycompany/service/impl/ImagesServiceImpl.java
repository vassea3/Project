package com.mycompany.service.impl;

import com.mycompany.model.Images;
import com.mycompany.service.intf.ImagesServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.dao.intf.ImagesIntf;

@Service("imageService")
public class ImagesServiceImpl implements ImagesServiceIntf {

    @Autowired
    private ImagesIntf imageIntf;

    public void setImageIntf(ImagesIntf imageIntf) {
        this.imageIntf = imageIntf;
    }

    @Override
    @Transactional
    public void save(Images image) {
        this.imageIntf.save(image);
    }

    @Override
    @Transactional
    public void update(Images image) {
        this.imageIntf.update(image);
    }

    @Override
    @Transactional
    public void delete(Images image) {
        this.imageIntf.delete(image);
    }

}
