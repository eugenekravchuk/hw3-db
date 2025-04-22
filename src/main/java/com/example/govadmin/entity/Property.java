package com.example.govadmin.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyID;

    @ManyToOne
    @JoinColumn(name = "CitizenID")
    private Citizen citizen;

    private String address;
    private String propertyType;
    private String size;
    private String zoningInformation;
    private Integer valuation;
    private Boolean isVerified;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ownershipChangeDate;

    // Getters & Setters
    public Integer getPropertyID() {
        return propertyID;
    }
    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }
    public Citizen getCitizen() {
        return citizen;
    }
    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getZoningInformation() {
        return zoningInformation;
    }
    public void setZoningInformation(String zoningInformation) {
        this.zoningInformation = zoningInformation;
    }
    public Integer getValuation() {
        return valuation;
    }
    public void setValuation(Integer valuation) {
        this.valuation = valuation;
    }
    public Boolean getIsVerified() {
        return isVerified;
    }
    public void setIsVerified(Boolean verified) {
        isVerified = verified;
    }
    public LocalDate getOwnershipChangeDate() {
        return ownershipChangeDate;
    }
    public void setOwnershipChangeDate(LocalDate ownershipChangeDate) {
        this.ownershipChangeDate = ownershipChangeDate;
    }
}
