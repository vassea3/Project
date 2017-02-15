package com.mycompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Messages {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nume;
    private String email;
    private String subiect;
    private String mesaj;
    private String ora;
    private String data;

    public Messages() {
    }

    public Messages(int id, String nume, String email, String subiect, String mesaj, String ora, String data) {
        this.id = id;
        this.nume = nume;
        this.email = email;
        this.subiect = subiect;
        this.mesaj = mesaj;
        this.ora = ora;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubiect() {
        return subiect;
    }

    public void setSubiect(String subiect) {
        this.subiect = subiect;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Messages{" + "id=" + id + ", nume=" + nume + ", email=" + email + ", subiect=" + subiect + ", mesaj=" + mesaj + ", ora=" + ora + ", data=" + data + '}';
    }

}
