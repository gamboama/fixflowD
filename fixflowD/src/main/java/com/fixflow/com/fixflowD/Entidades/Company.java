package com.fixflow.com.fixflowD.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @Column(length = 50)
    private String company_user;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 80)
    private String password;

    @Column(nullable = false, length = 100)
    private String Url;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Worker>workers;

    public Company() {
    }

    public Company(String company_user, String email, String password, String url, List<Worker> workers) {
        this.company_user = company_user;
        this.email = email;
        this.password = password;
        Url = url;
        this.workers = workers;
    }

    public String getCompany_user() {
        return company_user;
    }

    public void setCompany_user(String company_user) {
        this.company_user = company_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_user='" + company_user + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Url='" + Url + '\'' +
                ", workers=" + workers +
                '}';
    }
}
