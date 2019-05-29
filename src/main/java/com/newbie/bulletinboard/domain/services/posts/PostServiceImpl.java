package com.newbie.bulletinboard.domain.services.posts;

import com.newbie.bulletinboard.domain.repositories.posts.PostDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
}
