package com.fixflow.com.fixflowD.Entidades;

import jakarta.persistence.*;

@Entity
public class Reparation {

    @Id
    @Column(length = 100)
    private String ref;

    @Column(nullable = false, length = 200)
    private String modification;

    @Column(nullable = false, length = 50)
    private Float renueve;

    @ManyToOne(targetEntity = Phone.class)
    @JoinColumn(name = "phoneref")
    private Phone phone;

    @ManyToOne(targetEntity = Worker.class)
    @JoinColumn(name = "documento")
    private Worker worker;

    public Reparation() {
    }

    public Reparation(String ref, String modification, Float renueve, Phone phone, Worker worker) {
        this.ref = ref;
        this.modification = modification;
        this.renueve = renueve;
        this.phone = phone;
        this.worker = worker;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public Float getRenueve() {
        return renueve;
    }

    public void setRenueve(Float renueve) {
        this.renueve = renueve;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Reparation{" +
                "ref='" + ref + '\'' +
                ", modification='" + modification + '\'' +
                ", renueve=" + renueve +
                ", phone=" + phone +
                ", worker=" + worker +
                '}';
    }
}
