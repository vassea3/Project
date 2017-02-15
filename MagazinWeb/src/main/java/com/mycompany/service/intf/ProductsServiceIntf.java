package com.mycompany.service.intf;

import com.mycompany.model.Products;
import java.util.List;

public interface ProductsServiceIntf {

    public void save(Products product);

    public void update(Products product);

    public void delete(Products product);

    public List<String> findByCategory();

    public List<String> findBySubcategory(String category);

    public List<String> findByTip(String subcategory);

    public List<Products> findProductsByTip(String tip);

    public List<Products> findProductsByCategopria(String categoria);

    public List<Products> findProductsByCompany(String company);

    public List<Products> findProductsBySubcategopria(String subcategoria);

    public List<String> findAllCompany();

    public Products findProductByModel(String modelul);

    public Products findProductByCod(String cod);
}
