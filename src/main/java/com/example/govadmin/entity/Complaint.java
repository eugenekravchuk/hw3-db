package com.example.govadmin.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaintID;

    @ManyToOne
    @JoinColumn(name = "CitizenID")
    private Citizen citizen;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSubmitted;

    private String category;

    @Lob
    private String description;

    private String status;

    @Lob
    private String resolutionDetails;

    private String urgency;

    private Integer processID;  // ← just a simple foreign key reference

    // Getters & Setters
    public Integer getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(Integer complaintID) {
        this.complaintID = complaintID;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public LocalDate getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolutionDetails() {
        return resolutionDetails;
    }

    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionDetails = resolutionDetails;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }
}
