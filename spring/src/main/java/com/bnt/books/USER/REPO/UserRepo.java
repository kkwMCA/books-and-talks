package com.bnt.books.USER.REPO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bnt.books.USER.POJO.UserName;

@Repository
public interface UserRepo extends CrudRepository<UserName,String>{
    
    
}
