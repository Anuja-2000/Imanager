package com.example.Imanager.dto;

public class DriverDTO {
    
    private int id;
    private String name;
    private String licenseNumber;
    private String nic;
    private String contactNumber;
    private String bankAccountNumber;
    private String commissionPercentage;

    // Default constructor
    public DriverDTO() {}

    // Constructor with all fields
    public DriverDTO(int id, String name, String licenseNumber, String nic, 
                     String contactNumber, String bankAccountNumber, 
                     String commissionPercentage) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.commissionPercentage = commissionPercentage;
    }

    // Constructor without id (for creating new records)
    public DriverDTO(String name, String licenseNumber, String nic, 
                     String contactNumber, String bankAccountNumber, 
                     String commissionPercentage) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.commissionPercentage = commissionPercentage;
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
