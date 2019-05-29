package com.newbie.bulletinboard.domain.repositories.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;

public interface PostDAO {
    PostDTO getPostInformation(PostDTO postDTO) throws PostNotFoundException;
    PostDTO insertPost(PostDTO postDTO);
    PostDTO updatePost(PostDTO postDTO) throws PostNotFoundException;
}
