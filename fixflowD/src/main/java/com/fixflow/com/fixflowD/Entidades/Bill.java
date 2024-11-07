package com.fixflow.com.fixflowD.Entidades;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
public class Bill {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billNumber;

    @Column(nullable = false)
    private float totalPrice;

    @Column(nullable = false)
    private String entryDate;

    private float due;

    @Column(nullable = false, length = 30)
    private String clientName;

    @Column(length = 20)
    private String clientPhone;

    private float payment;

    @ManyToOne(targetEntity = Worker.class)
    @JoinColumn(name = "documento" )
    private Worker worker;


    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY)
    private List<Phone> phones;

    // Constructor, getters, and setters

    public Bill() {}

    public Bill(Integer billNumber, List<Phone> phones, float payment, String clientPhone, String clientName, float due, String entryDate, float totalPrice) {
        this.billNumber = billNumber;
        this.phones = phones;
        this.payment = payment;
        this.clientPhone = clientPhone;
        this.clientName = clientName;
        this.due = due;
        this.entryDate = entryDate;
        this.totalPrice = totalPrice;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public List<Phone> getPhone() {
        return phones;
    }

    public void setPhone(List<Phone> phone) {
        this.phones= phone;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNumber='" + billNumber + '\'' +
                ", totalPrice=" + totalPrice +
                ", entryDate='" + entryDate + '\'' +
                ", due=" + due +
                ", clientName='" + clientName + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", payment=" + payment +
                ", phone=" + phones +
                '}';
    }
}
