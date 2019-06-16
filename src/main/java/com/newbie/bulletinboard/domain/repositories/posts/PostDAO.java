package com.newbie.bulletinboard.domain.repositories.posts;

import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PostDAO {
    Optional<PostVO> getPostInformation(PostVO postDTO);

    PostVO insertPost(PostVO postDTO);

    PostVO updatePost(PostVO postDTO) throws PostNotFoundException;

    List<PostVO> getPostList(int page, int size);

    PostVO deletePost(PostVO postVO);
}
