package com.bnt.books.TestingControllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Deprecated
@RestController
class ControllerClass{

  
    @Deprecated
    //to get data ,pratik will get data
    @GetMapping("/getData")
    public Object getSomething(){
        HashMap hashMap=new HashMap<>();
        hashMap.put("name", "pratik");
        return hashMap;
    } 

    //send data
    @PostMapping("/send")
    public Object postMethodName(@RequestBody HashMap<String,Object> hashMap) {
        //TODO: process POST request
        hashMap.put("name", "sumedh");

        return hashMap;
        //db
        //return entity;
    }
    
    //send and get data,pratik will post
    @PostMapping("/sendGet")
    public HashMap sendGet(@RequestBody HashMap<String,Object> hashMap) {
        //TODO: process POST request
        System.out.println(hashMap);
        //return entity;
        return hashMap;
    }

    //send data as parameter
    @GetMapping("/getPara")
    public String getPara(@RequestParam(value = "id") String id) {
        return id;
    }
    
    @GetMapping("/getEnv")
    public String getEnv(@PathParam(value = "val") String val){
        return val;
    }
    
}