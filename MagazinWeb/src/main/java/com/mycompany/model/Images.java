package com.mycompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Images {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imagesId;
    private String imgName;
    private byte[] imgFile;

    public Images() {
    }

    public Images(int imagesId, String imgName, byte[] imgFile) {
        this.imagesId = imagesId;
        this.imgName = imgName;
        this.imgFile = imgFile;
    }

    public int getImagesId() {
        return imagesId;
    }

    public void setImagesId(int imagesId) {
        this.imagesId = imagesId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public byte[] getImgFile() {
        return imgFile;
    }

    public void setImgFile(byte[] imgFile) {
        this.imgFile = imgFile;
    }

    @Override
    public String toString() {
        return "Images{" + "imagesId=" + imagesId + ", imgName=" + imgName + ", imgFile=" + imgFile + '}';
    }

}
