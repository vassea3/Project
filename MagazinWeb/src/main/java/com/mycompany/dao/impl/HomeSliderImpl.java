package com.mycompany.dao.impl;

import com.mycompany.dao.intf.HomeSliderIntf;
import com.mycompany.model.HomeSlider;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeSliderImpl implements HomeSliderIntf {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void update(HomeSlider homeSlide) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(homeSlide);
    }

    @Override
    public HomeSlider findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("from HomeSlider where id like '" + id + "'");
        return (HomeSlider) serch.uniqueResult();
    }

    @Override
    public List<HomeSlider> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("from HomeSlider");
        return serch.list();
    }

}
