package pal.study.board.service;

import org.springframework.stereotype.Service;
import pal.study.board.domain.Posts;
import pal.study.board.domain.PostsRepository;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public void createContents(Posts posts) {
        postsRepository.save(posts);
    }
}
