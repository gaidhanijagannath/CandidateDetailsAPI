package com.TudipRecruitment.CandidateDetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "candidate_details") // table would be created as candidate_details **
@NoArgsConstructor
public class CandidateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String Address;

    @Column(name = "Email")
    private String Email;

    public CandidateDetails(String name, String phoneNumber, String address, String email) {
        super();
        /*this.id = id;*/
        this.name = name;
        this.phoneNumber = phoneNumber;
        Address = address;
        Email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CandidateDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }


}
