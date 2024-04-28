package com.bnt.books.TestingControllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bnt.books.USER.POJO.Post;
import com.bnt.books.USER.SERVICE.CommentService;
import com.bnt.books.USER.SERVICE.PostService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class MockNewPost {
    
    

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/getAllPost")
    public Object getMethodName() {
        // System.out.println(postService.findAllElements());
        // HashMap<Long,Object> hashMap=new HashMap<>();
        // for (Post i : postService.findAllElements()) {
        //     HashMap<String,Object> putHash=new HashMap<>();
        //     putHash.put("postname", i.getPostname());
        //     putHash.put("data", i.getImg());
        //     putHash.put("description", i.getDescription());
        //     putHash.put("comment",commentService.getComment(i.getPostid()));
        //     hashMap.put(i.getPostid(), putHash);
        // }
        
        HashMap<String,ArrayList<HashMap<String,Object>>> hashMap=new HashMap<>();
        ArrayList<HashMap<String,Object>> arrayList=new ArrayList<>();
        for (Post i : postService.findAllElements()) {
            HashMap<String,Object> putHash=new HashMap<>();
            putHash.put("postname", i.getPostname());
            putHash.put("data", i.getImg());
            putHash.put("description", i.getDescription());
            putHash.put("comment",commentService.getComment(i.getPostid()));
            arrayList.add(putHash);
        }

        hashMap.put("post", arrayList);
        arrayList=null;
/*
 * 
 * {data:[{},{},{}]
 * }
 */
        return hashMap;
    }

    @GetMapping("/api/get")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> list=new ArrayList<>();
        for (Post i : postService.findAllElements()) {
            list.add(i);
        }
        return ResponseEntity.ok(list);
    }
    
    

    // @PostMapping("/post")
    // public void postMethodName(@RequestBody HashMap<String,String> addpost) {
        
    //     Post post=new Post();
    //     post.setDescription(addpost.get("desc"));
    //     post.setPostname(addpost.get("name"));
    //     post.setImg(addpost.get("data"));
    //     post.setUsername(addpost.get("username"));
    //     post.setLikes(Long.parseLong("0"));

    //     postService.save(post);
    //     post=null;
    // }

    @PostMapping("/post")
    public void multipartSee(@RequestParam("image") MultipartFile file,
                        @RequestParam String postname,
                        @RequestParam String desc) throws IOException{
        System.out.println(file.getSize());
        System.out.println(desc);
        System.out.println(postname);
        Post post=new Post();
        post.setDescription(desc);
        post.setPostname(postname);
        post.setImg(file.getBytes());
        post.setUsername("sumedh");
        post.setLikes(Long.parseLong("0"));

        postService.save(post);

        post=null;
    }    
}
