package com.springbom.bulletinboard.service;

import com.springbom.bulletinboard.api.dto.PostV1;

import java.util.List;

public interface PostService {
    public List<PostV1> getPostList();

    public void addPost(PostV1 dto);

    public PostV1 getPost(Long id);

    public void updatePost(Long id, PostV1 dto);

    public void removePost(Long id);
}
