package com.bnt.books.USER.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/* 
create table if not exists user(
    username varchar(100) not null unique,
    email varchar(100) not null unique,
    noPost varchar(100) not null,
    profiledesc text not null,
    primary key(username)
);
*/

@Entity
@Table(name="users")
@Data
public class UserName {
    
    @Id
    @Column(name = "username",nullable = false)
    private String username;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="nopost",nullable = false)
    private String noPost;

    @Column(name="profiledesc",nullable = false)
    private String desc;
}
