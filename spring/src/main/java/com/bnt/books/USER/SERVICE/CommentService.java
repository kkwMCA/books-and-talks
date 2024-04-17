package com.bnt.books.USER.SERVICE;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.books.USER.POJO.Comment;
import com.bnt.books.USER.REPO.CommentRepo;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepo commentRepo;

    public String getComment(Long postid){
        Comment comment=commentRepo.findByPostid(postid);
        JSONObject jsonObject;
        if(comment!=null){
            jsonObject=new JSONObject(comment.getCommentdata());
            System.out.println(jsonObject);
        }else
            jsonObject=new JSONObject("{}");
        return jsonObject.toString();
    }
}
