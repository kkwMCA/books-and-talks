package com.bnt.books.USER.REPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnt.books.USER.POJO.Comment;
import java.util.List;


@Repository
public interface CommentRepo  extends JpaRepository<Comment,Long>{
    Comment findByPostid(Long postid);
}
