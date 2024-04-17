package com.bnt.books.TestingControllers;

import org.springframework.web.bind.annotation.RestController;

import com.bnt.books.USER.POJO.Post;
import com.bnt.books.USER.SERVICE.CommentService;
import com.bnt.books.USER.SERVICE.PostService;

import java.util.HashMap;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MockNewPost {
    
    

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/getAllPost")
    public Object getMethodName() {
        System.out.println(postService.findAllElements());
        HashMap<Long,Object> hashMap=new HashMap<>();
        for (Post i : postService.findAllElements()) {
            HashMap<String,Object> putHash=new HashMap<>();
            putHash.put("postname", i.getPostname());
            putHash.put("data", i.getImg());
            putHash.put("description", i.getDescription());
            putHash.put("comment",commentService.getComment(i.getPostid()));
            hashMap.put(i.getPostid(), putHash);
        }
        
        return hashMap;
    }
    
}
