package com.fixflow.com.fixflowD.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Phone {

    @Id
    @Column(length = 30)
    private String phoneref;


    @Column(nullable = false, length = 20)
    private String device;

    @Column(nullable = false)
    private float individualPrice;

    @Column(length = 250)
    private String details;

    @Column(length = 20)
    private String dispType;

    private Boolean delivered;
    private Boolean repaired;


    private String dateDelivered;

    @ManyToOne(targetEntity = Brands.class )
    @JoinColumn(name = "brands")
    private Brands brands;

    @ManyToOne(targetEntity = Bill.class)
    @JoinColumn(name = "bill_number")
    private Bill bill;


    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
    private List<Reparation>reparations;

    @ManyToMany(targetEntity = Worker.class, fetch = FetchType.LAZY)
    @JoinTable(name = "Delivery",
            joinColumns = @JoinColumn(name = "phoneref"),
            inverseJoinColumns = @JoinColumn(name = "documento"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"phoneref","documento"})
    )
    private List<Worker> workers;




    public Phone() {
    }

    public Phone(String phoneref, String device, float individualPrice, String details, String dispType, Boolean delivered, Boolean repaired, String dateDelivered, Brands brands, Bill bill) {
        this.phoneref = phoneref;
        this.device = device;
        this.individualPrice = individualPrice;
        this.details = details;
        this.dispType = dispType;
        this.delivered = delivered;
        this.repaired = repaired;
        this.dateDelivered = dateDelivered;
        this.brands = brands;
        this.bill = bill;
    }

    public String getPhoneref() {
        return phoneref;
    }

    public void setPhoneref(String phoneref) {
        this.phoneref = phoneref;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public String getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(String dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public Boolean getRepaired() {
        return repaired;
    }

    public void setRepaired(Boolean repaired) {
        this.repaired = repaired;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDispType() {
        return dispType;
    }

    public void setDispType(String dispType) {
        this.dispType = dispType;
    }

    public float getIndividualPrice() {
        return individualPrice;
    }

    public void setIndividualPrice(float individualPrice) {
        this.individualPrice = individualPrice;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneref='" + phoneref + '\'' +
                ", device='" + device + '\'' +
                ", individualPrice=" + individualPrice +
                ", details='" + details + '\'' +
                ", dispType='" + dispType + '\'' +
                ", delivered=" + delivered +
                ", repaired=" + repaired +
                ", dateDelivered='" + dateDelivered + '\'' +
                ", brands=" + brands +
                ", bill=" + bill +
                '}';
    }
}
