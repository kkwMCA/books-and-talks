package com.bnt.books.USER.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.books.USER.POJO.UserName;
import com.bnt.books.USER.REPO.UserRepo;



@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public UserName getUser(String username){
            return userRepo.findById(username).orElse(null);
    }
}
