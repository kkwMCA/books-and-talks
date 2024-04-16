package com.bnt.books.USER.SERVICE;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.books.USER.POJO.Post;
import com.bnt.books.USER.REPO.PostRepo;

@Service
public class PostService {
    

    @Autowired
    private PostRepo postRepo;


    public List<Post> findAllElements() {
        return postRepo.findAll();
    }
}
