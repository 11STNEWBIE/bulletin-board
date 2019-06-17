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
                .map(x -> modelMapper.map(x, PostV1.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPost(PostV1 dto) {
        Post post = modelMapper.map(dto, Post.class);
        postRepository.save(post);
    }

    @Override
    public PostV1 getPost(Long id) {
        Post post = getPostById(id);
        return modelMapper.map(post, PostV1.class);
    }

    @Override
    public void updatePost(Long id, PostV1 dto) {
        getPostById(id);
        postRepository.save(modelMapper.map(dto, Post.class));
    }

    @Override
    public void removePost(Long id) {
        getPostById(id);
        postRepository.deleteById(id);
    }

    private Post getPostById(Long id) throws PostNotFoundException {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }
}
