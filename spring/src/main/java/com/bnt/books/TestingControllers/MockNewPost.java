package com.bnt.books.TestingControllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bnt.books.USER.POJO.Post;
import com.bnt.books.USER.SERVICE.CommentService;
import com.bnt.books.USER.SERVICE.PostService;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class MockNewPost {
    
    

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Deprecated
    @GetMapping("/getAllPost")
    public Object getMethodName() {
        
        
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

    @GetMapping("/api/getComm")
    public ResponseEntity<List<Post>> getCommPosts(@RequestParam String community) {
        List<Post> list=new ArrayList<>();
        for (Post i : postService.getCommPost(community)) {
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
                        @RequestParam String community,
                        @RequestParam String desc) throws IOException{
        System.out.println(file.getSize());
        System.out.println(desc);
        System.out.println(postname);
        System.out.println(community);
        community=community.toLowerCase();
        Post post=new Post();
        post.setDescription(desc);
        post.setPostname(postname);
        post.setImg(file.getBytes());
        post.setUsername("sumedh");
        post.setCommunity(community);
        post.setLikes(Long.parseLong("0"));
        post.setContent(file.getContentType());

        postService.save(post);

        post=null;
    }    

    @PostMapping("/like")
    public void getMethodName(@RequestParam("id") String id) {
        postService.like(Long.parseLong(id));
    }

    @PostMapping("/dislike")
    public void getDislike(@RequestParam("id") String id) {
        postService.dislike(Long.parseLong(id));
    }

    // @PostMapping("/download")
    // public ResponseEntity getDownload(@RequestParam("id") String id) {
    //     return 
    // }
    // @RequestMapping(value = "/download", method = RequestMethod.GET,produces ={} MediaType.IMAGE_JPEG_VALUE)
    // public @ResponseBody byte[] getImageAsByteArray(@RequestParam("id") String id) throws IOException {
    //  return postService.getData(Long.parseLong(id));
    
    // }

    @GetMapping("/download")
    public HashMap<String,Object> getDownload(@RequestParam String id) {
        HashMap<String,Object> hashMap=new HashMap<>();
        Post post=postService.get(Long.parseLong(id));
       
        hashMap.put("data",post.getImg());
        hashMap.put("content", post.getContent());

        return hashMap;
    }
    
    
}
