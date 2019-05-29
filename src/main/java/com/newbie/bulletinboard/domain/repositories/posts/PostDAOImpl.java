package com.newbie.bulletinboard.domain.repositories.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PostDAOImpl implements PostDAO{
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostDTO getPostInformation(PostDTO postDTO) throws PostNotFoundException {
        Optional<PostDTO> byId = postRepository.findById(postDTO.getPostId());
        return byId.orElseThrow(() -> new PostNotFoundException(postDTO.getPostId()));
    }

    @Override
    public PostDTO insertPost(PostDTO postDTO) {
        postDTO.setCreateDate(new Date());
        return postRepository.save(postDTO);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) throws PostNotFoundException {
        Optional<PostDTO> byId = postRepository.findById(postDTO.getPostId());
        byId.orElseThrow(() -> new PostNotFoundException(postDTO.getPostId()));
        postDTO.setUpdateDate(new Date());
        postDTO.setUpdateId(postDTO.getUpdateId());
        return postRepository.save(postDTO);
    }
}
