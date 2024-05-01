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

    public void save(Post post){
        postRepo.save(post);
    }

    public void like(Long id){
        Post post=postRepo.findById(id).orElse(null);
        Long like=post.getLikes();
        post.setLikes(like+1);
        postRepo.save(post);
        post=null;
        like=null;
    }

    public void dislike(long id) {
        Post post=postRepo.findById(id).orElse(null);
        Long like=post.getLikes();
        post.setLikes(like-1);
        postRepo.save(post);
        post=null;
        like=null;
    }

    public byte[] getData(long id){
        Post post=postRepo.findById(id).orElse(null);
        byte[] data=post.getImg();
        post=null;
        return data;
    }
}
