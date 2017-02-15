package com.mycompany.dao.impl;

import com.mycompany.dao.intf.ContactPageIntf;
import com.mycompany.model.ContactPage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactPageImpl implements ContactPageIntf {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void update(ContactPage contPage) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(contPage);
    }

    @Override
    public ContactPage findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("from ContactPage where id like '" + id + "'");
        return (ContactPage) serch.uniqueResult();
    }

}
