package com.hutech.loginproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.loginproject.model.comment.Comment;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
