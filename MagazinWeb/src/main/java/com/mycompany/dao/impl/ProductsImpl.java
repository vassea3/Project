package com.mycompany.dao.impl;

import com.mycompany.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mycompany.dao.intf.ProductsIntf;
import java.util.List;
import org.hibernate.Query;

@Repository
public class ProductsImpl implements ProductsIntf {

    private static final Logger logger = LoggerFactory.getLogger(ProductsImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void save(Products product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        logger.info("Product saved successfully, product Details=" + product);
    }

    @Override
    public List<String> findByCategory() {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("select categoria from Products");
        return serch.list();
    }

    @Override
    public List<String> findBySubcategory(String category) {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("select subcategoria from Products where categoria like '" + category + "'");
        return serch.list();
    }

    @Override
    public List<String> findByTip(String subcategory) {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("select tipul from Products where subcategoria like '" + subcategory + "'");
        return serch.list();
    }

    @Override
    public List<Products> findProductsByTip(String tip) {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery(" from Products where tipul like '" + tip + "'");
        return serch.list();
    }

    @Override
    public List<Products> findProductsByCategopria(String categoria) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Products> prodList = session.createQuery("from Products where categoria like '" + categoria + "'").list();
        return prodList;
    }

    @Override
    public List<Products> findProductsBySubcategopria(String subcategoria) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Products> prodList = session.createQuery("from Products where subcategoria like '" + subcategoria + "'").list();
        return prodList;
    }

    @Override
    public Products findProductByModel(String modelul) {
        Session session = this.sessionFactory.getCurrentSession();
        Products prod = (Products) session.createQuery("from Products where modelul like '" + modelul + "'").uniqueResult();
        return prod;
    }

    @Override
    public void update(Products product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product updated successfully, product Details=" + product);
    }

    @Override
    public void delete(Products product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(product);

    }

    @Override
    public Products findProductByCod(String cod) {
        Session session = this.sessionFactory.getCurrentSession();
        Products prod = (Products) session.createQuery("from Products where cod like '" + cod + "'").uniqueResult();
        return prod;
    }

    @Override
    public List<String> findAllCompany() {
        Session session = this.sessionFactory.getCurrentSession();
        Query serch = session.createQuery("select compania from Products");
        return serch.list();
    }

    @Override
    public List<Products> findProductsByCompany(String company) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Products> prodList = session.createQuery("from Products where compania like '" + company + "'").list();
        return prodList;
    }

}
