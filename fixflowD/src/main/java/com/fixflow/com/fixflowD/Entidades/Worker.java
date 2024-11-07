package com.fixflow.com.fixflowD.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Worker {

    @Id
    @Column(nullable = false, length = 30)
    private String documento;

    @Column(nullable = false, length = 30)
    private String wname;

    @Column(nullable = false, length = 20)
    private String password;

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY)
    private List<Bill> bills;

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY)
    private List<Reparation>reparations;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_user")
    private Company company;

    public Worker() {
    }

    public Worker(String documento, String wname, String password, List<Bill> bills, List<Reparation> reparations, Company company) {
        this.documento = documento;
        this.wname = wname;
        this.password = password;
        this.bills = bills;
        this.reparations = reparations;
        this.company = company;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Reparation> getReparations() {
        return reparations;
    }

    public void setReparations(List<Reparation> reparations) {
        this.reparations = reparations;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "documento='" + documento + '\'' +
                ", wname='" + wname + '\'' +
                ", password='" + password + '\'' +
                ", bills=" + bills +
                ", reparations=" + reparations +
                ", company=" + company +
                '}';
    }
}
