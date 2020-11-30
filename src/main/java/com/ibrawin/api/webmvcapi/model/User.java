package com.ibrawin.api.webmvcapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String email;

    private String password;

    private String phoneNumber;

    private String department;

    private String jobTitle;

}