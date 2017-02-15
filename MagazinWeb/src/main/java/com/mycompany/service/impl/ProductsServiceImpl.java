package com.mycompany.service.impl;

import com.mycompany.dao.intf.ProductsIntf;
import com.mycompany.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.service.intf.ProductsServiceIntf;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("productsService")
public class ProductsServiceImpl implements ProductsServiceIntf {

    @Autowired
    private ProductsIntf productsIntf;

    public void setProductsIntf(ProductsIntf productsIntf) {
        this.productsIntf = productsIntf;
    }

    @Override
    @Transactional
    public void save(Products product) {
        this.productsIntf.save(product);
    }

    @Override
    @Transactional
    public List<String> findByCategory() {
        return this.productsIntf.findByCategory();
    }

    @Override
    @Transactional
    public List<String> findBySubcategory(String category) {
        return this.productsIntf.findBySubcategory(category);
    }

    @Override
    @Transactional
    public List<String> findByTip(String subcategory) {
        return this.productsIntf.findByTip(subcategory);
    }

    @Override
    @Transactional
    public List<Products> findProductsByTip(String tip) {
        return this.productsIntf.findProductsByTip(tip);
    }

    @Override
    @Transactional
    public List<Products> findProductsByCategopria(String categoria) {
        return this.productsIntf.findProductsByCategopria(categoria);
    }

    @Override
    @Transactional
    public List<Products> findProductsBySubcategopria(String subcategoria) {
        return this.productsIntf.findProductsBySubcategopria(subcategoria);
    }

    @Override
    @Transactional
    public Products findProductByModel(String modelul) {
        return this.productsIntf.findProductByModel(modelul);
    }

    @Override
    @Transactional
    public void update(Products product) {
        this.productsIntf.update(product);
    }

    @Override
    @Transactional
    public void delete(Products product) {
        this.productsIntf.delete(product);
    }

    @Override
    @Transactional
    public Products findProductByCod(String cod) {
        return this.productsIntf.findProductByCod(cod);
    }

    @Override
    @Transactional
    public List<String> findAllCompany() {
        return this.productsIntf.findAllCompany();
    }

    @Override
    @Transactional
    public List<Products> findProductsByCompany(String company) {
        return this.productsIntf.findProductsByCompany(company);
    }
}
