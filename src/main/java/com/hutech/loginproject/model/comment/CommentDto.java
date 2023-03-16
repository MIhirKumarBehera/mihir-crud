package com.hutech.loginproject.model.comment;

import com.hutech.loginproject.model.post.PostDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
private long id;
private String content;

}
