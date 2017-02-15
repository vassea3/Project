package com.mycompany.dao.impl;

import com.mycompany.model.Images;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.dao.intf.ImagesIntf;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ImagesImpl implements ImagesIntf {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void save(Images images) {
        this.sessionFactory.getCurrentSession().save(images);
    }

    @Override
    public void update(Images image) {
        this.sessionFactory.getCurrentSession().update(this);
    }

    @Override
    public void delete(Images image) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(image);
    }

}
