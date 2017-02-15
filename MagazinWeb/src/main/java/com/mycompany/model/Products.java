package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String categoria;
    private String subcategoria;
    private String tipul;
    private String modelul;
    private String compania;
    private String cod;
    private String pret;
    private String descrierea;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "ProductImages", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "imagesId"))
    private List<Images> images;

    public Products() {
    }

    public Products(int productId, String categoria, String subcategoria, String tipul, String modelul, String compania, String cod, String pret, String descrierea) {
        this.productId = productId;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.tipul = tipul;
        this.modelul = modelul;
        this.compania = compania;
        this.cod = cod;
        this.pret = pret;
        this.descrierea = descrierea;
    }

    public Products(int productId, String categoria, String subcategoria, String tipul, String modelul, String compania, String cod, String pret, String descrierea, List<Images> images) {
        this.productId = productId;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.tipul = tipul;
        this.modelul = modelul;
        this.compania = compania;
        this.cod = cod;
        this.pret = pret;
        this.descrierea = descrierea;
        this.images = images;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getTipul() {
        return tipul;
    }

    public void setTipul(String tipul) {
        this.tipul = tipul;
    }

    public String getModelul() {
        return modelul;
    }

    public void setModelul(String modelul) {
        this.modelul = modelul;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getDescrierea() {
        return descrierea;
    }

    public void setDescrierea(String descrierea) {
        this.descrierea = descrierea;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Products{" + "productId=" + productId + ", categoria=" + categoria + ", subcategoria=" + subcategoria + ", tipul=" + tipul + ", modelul=" + modelul + ", compania=" + compania + ", cod=" + cod + ", pret=" + pret + ", descrierea=" + descrierea + ", images=" + images + '}';
    }
    //   public List<String> imagesName(){
//        List<String> imgList= new ArrayList<String>();
//        for (Images image : images) {
//            imgList.add(image.getImgName());
//        }
//        return imgList;
//    }

}
