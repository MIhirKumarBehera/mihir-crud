package com.hutech.loginproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hutech.loginproject.model.comment.Comment;

public interface Commentrepo extends JpaRepository<Comment, Long> {

}
