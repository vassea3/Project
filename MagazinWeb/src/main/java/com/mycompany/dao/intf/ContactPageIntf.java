package com.mycompany.dao.intf;

import com.mycompany.model.ContactPage;

public interface ContactPageIntf {

    public void update(ContactPage contPage);

    public ContactPage findById(int id);

}
