package com.fixflow.com.fixflowD.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 60)
    private String namee;

    @OneToMany(targetEntity = Phone.class, fetch = FetchType.LAZY, mappedBy = "brands")
    private List<Phone> phone;

    public Brands() {
    }

    public Brands(int id, String namee, List<Phone> phone) {
        this.id = id;
        this.namee = namee;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Brands{" +
                "id=" + id +
                ", namee='" + namee + '\'' +
                ", phone=" + phone +
                '}';
    }
}
