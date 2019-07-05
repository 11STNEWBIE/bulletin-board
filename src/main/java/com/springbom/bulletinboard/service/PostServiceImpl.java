package com.springbom.bulletinboard.service;

import com.springbom.bulletinboard.api.dto.PostV1;
import com.springbom.bulletinboard.exceptions.PostNotFoundException;
import com.springbom.bulletinboard.repository.PostRepository;
import com.springbom.bulletinboard.repository.entity.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    @Override
    public List<PostV1> getPostList() {
        return postRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public PostV1 getPost(Long id) {
        Post post = getPostById(id);
        return modelMapper.map(post, PostV1.class);
    }

    @Override
    public void updatePost(Long id, Post post) {
        getPostById(id);
        postRepository.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void removePost(Long id) {
        getPostById(id);
        postRepository.deleteById(id);
    }

    private Post getPostById(Long id) throws PostNotFoundException {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    private PostV1 convertToDto(Post post) {
        PostV1 dto = modelMapper.map(post, PostV1.class);
        return dto;
    }
}
