package com.springbom.bulletinboard.service;

import com.springbom.bulletinboard.api.dto.PostV1;
import com.springbom.bulletinboard.repository.entity.Post;

import java.util.List;

public interface PostService {
    public List<PostV1> getPostList();

    public void addPost(Post post);

    public PostV1 getPost(Long id);

    public void updatePost(Long id, Post post);

    public void removePost(Long id);
}
