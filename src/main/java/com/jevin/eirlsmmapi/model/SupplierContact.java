package com.jevin.eirlsmmapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
public class SupplierContact {

    @Id
    private int id;
    private String phone;
    private String email;
    private String locationMain;
    private String locationDelivery;
    private String locationCollection;

    @OneToOne
    @JoinColumn
    @MapsId
    @JsonIgnoreProperties("supplierContact")
    private Supplier supplier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocationMain() {
        return locationMain;
    }

    public void setLocationMain(String locationMain) {
        this.locationMain = locationMain;
    }

    public String getLocationDelivery() {
        return locationDelivery;
    }

    public void setLocationDelivery(String locationDelivery) {
        this.locationDelivery = locationDelivery;
    }

    public String getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(String locationCollection) {
        this.locationCollection = locationCollection;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
