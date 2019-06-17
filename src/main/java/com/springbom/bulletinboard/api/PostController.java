package com.springbom.bulletinboard.api;

import com.springbom.bulletinboard.api.dto.PostV1;
import com.springbom.bulletinboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostV1> getPostList() {
        return postService.getPostList();
    }

    @PostMapping
    public void addPost(@RequestBody PostV1 dto) {
        postService.addPost(dto);
    }

    @GetMapping("/{id}")
    public PostV1 getPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") Long id,
                           @RequestBody PostV1 dto) {
        postService.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public void removePost(@PathVariable("id") Long id) {
        postService.removePost(id);
    }
}