package com.example.Imanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dl_no")
    private String licenseNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "contact_no")
    private String contactNumber;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "commission_percentage")
    private String commissionPercentage;

    // Default constructor
    public Driver() {}

    // Constructor with parameters
    public Driver(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }


    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(String commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }
}
