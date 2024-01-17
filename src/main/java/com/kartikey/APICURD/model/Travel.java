package com.kartikey.APICURD.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Travel")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trid")
    private Long trid;

    @Column(name = "tName")
    private String tName;

    @Column(name = "tDesc")
    private String tDesc;

    @Column(name = "tDate")
    private String tDate;
}
