package com.hutech.loginproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.loginproject.model.category.Category;
import com.hutech.loginproject.model.post.Post;
import com.hutech.loginproject.model.user.User;
@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
 List<Post> findByUser(User user);
 List<Post> findByCategory(Category category);
}
