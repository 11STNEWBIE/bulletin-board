package pal.study.board.service;

import org.springframework.stereotype.Service;
import pal.study.board.domain.Posts;
import pal.study.board.domain.PostsRepository;
import pal.study.board.dto.PostsDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<PostsDTO> findAllPosts() {
        return postsRepository.findAll()
                              .stream()
                              .map(PostsDTO::new)
                              .collect(Collectors.toList());
    }

    public PostsDTO findPosts(long postsId) {
        return postsRepository.findById(postsId)
                              .map(PostsDTO::new)
                              .orElse(new PostsDTO());
    }

    public String savePosts(Posts posts) {
        return postsRepository.save(posts)
                              .getId()
                              .toString();
    }
}
