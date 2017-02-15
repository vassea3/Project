package com.mycompany.dao.impl;

import com.mycompany.dao.intf.UsersIntf;
import com.mycompany.model.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersImpl implements UsersIntf {

    private static final Logger logger = LoggerFactory.getLogger(UsersImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void save(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User saved successfully, User Details=" + user);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Users users = (Users) session.load(Users.class, new Integer(id));
        if (null != users) {
            session.delete(users);
        }
        logger.info("User deleted successfully, User details=" + users);
    }

    @Override
    public Users findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Users users = (Users) session.load(Users.class, new Integer(id));
        logger.info("User loaded successfully, User details=" + users);
        return users;
    }

    @Override
    public Users findByUsername(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("from Users where username like '" + username + "'");
        Users users = (Users) serch.uniqueResult();
        logger.info("User loaded successfully, User details=" + users);

        return users;
    }

    @Override
    public List<Users> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User updated successfully, User Details=" + user);
    }

    @Override
    public List<String> findAllUsernames() {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("select username from Users");
        return serch.list();
    }

}
