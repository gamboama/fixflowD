package com.fixflow.com.fixflowD.Entidades;

import jakarta.persistence.*;


@Entity
public class Devices {

    @Id
    @Column(length = 80)
    private String name;

    @ManyToOne
    @JoinColumn(name = "namee", nullable = false)
    private Brands brands;

    public Devices() {
    }

    public Devices(String name, Brands brands) {
        this.name = name;
        this.brands = brands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "name='" + name + '\'' +
                ", brands=" + brands +
                '}';
    }
}
