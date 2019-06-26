package com.newbie.bulletinboard.domain.services.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;

import java.util.List;

public interface PostService {
    PostDTO insertPost(PostDTO postDTO);

    PostDTO getPost(PostDTO postDTO) throws PostNotFoundException;

    PostDTO updatePostContent(PostDTO postDTO) throws PostNotFoundException, Exception;

    List<PostDTO> getPostList(int page, int size);

    PostDTO deletePosts(PostDTO postDTO) throws PostNotFoundException;
}
