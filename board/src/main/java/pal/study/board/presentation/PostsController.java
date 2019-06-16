package pal.study.board.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pal.study.board.domain.Posts;
import pal.study.board.dto.PostsDTO;
import pal.study.board.service.PostsService;

@Controller
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/form")
    public String postForm() {
        return "/postsForm";
    }

    @GetMapping("/{postsId}")
    public String post(@PathVariable long postsId, Model model) throws Exception {
        PostsDTO posts = postsService.findPosts(postsId);
        model.addAttribute("posts", posts);
        return "/posts";
    }

    @PostMapping
    public String addPost(Posts posts) {
        return "redirect:/posts/" + postsService.savePosts(posts);
    }
}