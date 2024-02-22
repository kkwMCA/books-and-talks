package com.bnt.books;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ControllerClass{

    @GetMapping("/getData")
    public Object getSomething(){
        HashMap hashMap=new HashMap<>();
        hashMap.put("name", "pratik");
        return hashMap;
    } 
}