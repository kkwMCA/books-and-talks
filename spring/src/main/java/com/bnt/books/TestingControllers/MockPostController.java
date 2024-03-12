package com.bnt.books.TestingControllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MockPostController {
    
    //mock db
    HashMap<String,Object> hashMap;

    
    @GetMapping("/getPost")
    public HashMap getPost() {
        hashMap=new HashMap<>();
        String str="hello, my name is sumedh ahire and i am doing java!";
        PostObject postObject=PostObject.builder().userid(100)
                                            .community("java")
                                            .data(str)
                                            .description("about me")
                                            .build();
        
                                            hashMap.put("1",postObject);
        System.out.println(hashMap);
        return hashMap;
    }
    
}
