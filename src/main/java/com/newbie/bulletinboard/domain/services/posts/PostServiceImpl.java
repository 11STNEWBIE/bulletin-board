package com.newbie.bulletinboard.domain.services.posts;

import com.newbie.bulletinboard.domain.repositories.posts.PostMapper;
import com.newbie.bulletinboard.domain.repositories.posts.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImpl {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
}
