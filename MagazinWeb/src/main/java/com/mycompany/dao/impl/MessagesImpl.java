package com.mycompany.dao.impl;

import com.mycompany.dao.intf.MessagesIntf;
import com.mycompany.model.Messages;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessagesImpl implements MessagesIntf {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void save(Messages message) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(message);
    }

    @Override
    public void delete(Messages message) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(message);
    }

    @Override
    public List<Messages> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Messages").list();
    }

    @Override
    public Messages findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Messages) session.createQuery("from Messages where id like '" + id + "'").uniqueResult();
    }

}
