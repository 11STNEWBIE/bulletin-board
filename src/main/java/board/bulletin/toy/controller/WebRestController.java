package board.bulletin.toy.controller;

import board.bulletin.toy.controller.dto.PostsSaveRequestDto;
import board.bulletin.toy.domain.posts.Posts;
import board.bulletin.toy.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/posts")
    public List<Posts> hello() {
        return postsService.getPosts();
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody PostsSaveRequestDto dto) {
        postsService.update(id, dto);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postsService.delete(id);
    }
}