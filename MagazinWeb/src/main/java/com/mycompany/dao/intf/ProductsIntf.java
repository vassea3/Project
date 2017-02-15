/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.intf;

import com.mycompany.model.Products;
import java.util.List;

/**
 *
 * @author Taniusha
 */
public interface ProductsIntf {
    public void save(Products product);
    public void update(Products product);
    public void delete(Products product);
    public List<String> findByCategory();
    public List<String> findBySubcategory(String category);
    public List<String> findByTip(String subcategory);
    public List<String> findAllCompany();
    public List<Products> findProductsByTip(String tip);
    public List<Products> findProductsByCategopria(String categoria);
     public List<Products> findProductsBySubcategopria(String subcategoria);
      public List<Products> findProductsByCompany(String company);
     public Products findProductByModel(String modelul);
     public Products findProductByCod(String cod);
     
    
}
