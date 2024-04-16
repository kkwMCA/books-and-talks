package com.bnt.books.USER.POJO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {
    @Id
    private Long postid;
    
    private String postname;

    @Lob
    private byte[] img;

    private String description;
}
