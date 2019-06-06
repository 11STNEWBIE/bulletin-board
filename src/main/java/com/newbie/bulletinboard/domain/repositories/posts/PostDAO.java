package com.newbie.bulletinboard.domain.repositories.posts;

import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;

import java.util.List;

public interface PostDAO {
    PostVO getPostInformation(PostVO postDTO) throws PostNotFoundException;

    PostVO insertPost(PostVO postDTO);

    PostVO updatePost(PostVO postDTO) throws PostNotFoundException;

    List<PostVO> getPostList(int page, int size);
}
