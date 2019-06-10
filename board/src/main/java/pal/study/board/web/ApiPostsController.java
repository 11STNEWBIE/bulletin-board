package pal.study.board.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pal.study.board.domain.Posts;
import pal.study.board.service.PostsService;

@RestController
@RequestMapping("/api/posts")
public class ApiPostsController {

    private final PostsService postsService;

    public ApiPostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping
    public ResponseEntity<Void> create(Posts posts) {
        postsService.createContents(posts);
        return ResponseEntity.ok().build();
    }
}
