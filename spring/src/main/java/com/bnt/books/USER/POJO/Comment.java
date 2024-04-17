package com.bnt.books.USER.POJO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * create table if not exists comment(
    commentid number not null unique,
    postid number not null unique,
    commentdata text not null,
    primary key(commentid)
);
 */
@Entity
@Table(name = "comment")
@Data
public class Comment {
    
    @Id
    private Long commentid;

    private Long postid;

    private String commentdata;
}
