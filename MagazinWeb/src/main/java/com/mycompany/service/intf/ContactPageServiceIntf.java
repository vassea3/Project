package com.mycompany.service.intf;

import com.mycompany.model.ContactPage;

public interface ContactPageServiceIntf {

    public void update(ContactPage contPage);

    public ContactPage findById(int id);
}
