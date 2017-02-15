package com.mycompany.service.impl;

import com.mycompany.dao.intf.ContactPageIntf;
import com.mycompany.model.ContactPage;
import com.mycompany.service.intf.ContactPageServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
public class ContactPageServiceImpl implements ContactPageServiceIntf {

    @Autowired
    private ContactPageIntf contPageIntf;

    public void setContPageIntf(ContactPageIntf contPageIntf) {
        this.contPageIntf = contPageIntf;
    }

    @Override
    @Transactional
    public void update(ContactPage contPage) {
        this.contPageIntf.update(contPage);
    }

    @Override
    @Transactional
    public ContactPage findById(int id) {
        return this.contPageIntf.findById(id);
    }

}
