package com.bnt.books.USER.REPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnt.books.USER.POJO.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

// create table if not exists post(
//     postid number not null unique,
//     postname text not null,
//     img VARBINARY(MAX) not null,
//     description text not null,
//     primary key(postid)
// );


@Repository
public interface PostRepo extends JpaRepository<Post,Long>{
    



}
