package com.bnt.books.entities;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer post_id;

    @Column(name = "post_name", nullable = false, length = 10)
    private String com_id;
    private String image;
    private String data;
    private String description;
    private Timestamp datetime;

}
