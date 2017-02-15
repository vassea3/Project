package com.mycompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "homeSlider")
public class HomeSlider {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titlul;
    private String descrierea;
    private String reducerea;
    private String imgName;
    private byte[] imgBytes;

    public HomeSlider() {
    }

    public HomeSlider(int id, String titlul, String descrierea, String reducerea, String imgName, byte[] imgBytes) {
        this.id = id;
        this.titlul = titlul;
        this.descrierea = descrierea;
        this.reducerea = reducerea;
        this.imgName = imgName;
        this.imgBytes = imgBytes;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlul() {
        return titlul;
    }

    public void setTitlul(String titlul) {
        this.titlul = titlul;
    }

    public String getDescrierea() {
        return descrierea;
    }

    public void setDescrierea(String descrierea) {
        this.descrierea = descrierea;
    }

    public String getReducerea() {
        return reducerea;
    }

    public void setReducerea(String reducerea) {
        this.reducerea = reducerea;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "HomeSlider{" + "id=" + id + ", titlul=" + titlul + ", descrierea=" + descrierea + ", reducerea=" + reducerea + ", imgName=" + imgName + ", imgBytes=" + imgBytes + '}';
    }

}
