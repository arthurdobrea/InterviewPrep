package com.project.preparation.practice.model;

import jakarta.persistence.*;


@Entity
@lombok.Data
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Data() {

    }

    public Data(String name) {
        this.name = name;
    }
}
