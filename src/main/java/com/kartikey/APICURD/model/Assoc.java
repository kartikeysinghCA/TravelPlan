package com.kartikey.APICURD.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Assoc")
public class Assoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assoid;

    @Column(name="empid")
    private Long empid;

    @Column(name="trid")
    private Long trid;
}
