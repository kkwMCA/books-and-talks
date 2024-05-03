package com.bnt.books.USER.REPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnt.books.USER.POJO.Community;

@Repository
public interface CommRepo extends JpaRepository<Community,String>{
    
}
