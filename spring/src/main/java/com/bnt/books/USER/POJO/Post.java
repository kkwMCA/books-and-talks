package com.bnt.books.USER.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="posttable")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postid;
    
    private String username;

    private String postname;

    @Lob
    private byte[] img;

    @Column(name="description")
    private String description;

    private Long likes;

    private String community;
}
