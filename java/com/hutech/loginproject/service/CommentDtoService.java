package com.hutech.loginproject.service;

import java.util.List;

import com.hutech.loginproject.model.comment.CommentDto;

public interface CommentDtoService {
CommentDto createComment(CommentDto commentDto,Long PostId);
public void deleteByid(Long id);
List<CommentDto> findAllDetails();
}
