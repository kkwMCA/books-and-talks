package com.bnt.books.USER.SERVICE;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.books.USER.REPO.CommRepo;
import com.bnt.books.USER.POJO.Community;

@Service
public class CommService {
    
    @Autowired
    private CommRepo commRepo;

    public List<Community> getAll(){
        return commRepo.findAll();
    }

    
}
