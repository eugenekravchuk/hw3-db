package com.example.govadmin.entity;

import javax.persistence.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Citizen")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer citizenID;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private Integer age;
    private String address;
    private String contactInformation;
    @Lob
    private String familyDetails;
    private Boolean registeredOnline;

    // Getters & Setters
    public Integer getCitizenID() {
        return citizenID;
    }
    public void setCitizenID(Integer citizenID) {
        this.citizenID = citizenID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContactInformation() {
        return contactInformation;
    }
    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
    public String getFamilyDetails() {
        return familyDetails;
    }
    public void setFamilyDetails(String familyDetails) {
        this.familyDetails = familyDetails;
    }
    public Boolean getRegisteredOnline() {
        return registeredOnline;
    }
    public void setRegisteredOnline(Boolean registeredOnline) {
        this.registeredOnline = registeredOnline;
    }
}