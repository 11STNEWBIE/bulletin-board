package pal.study.board.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pal.study.board.dto.PostsDTO;
import pal.study.board.service.PostsService;

import java.util.List;

@Controller
public class HomeController {

    private final PostsService postsService;

    public HomeController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<PostsDTO> posts = postsService.findAllPosts();

        model.addAttribute("posts", posts);
        return "/index";
    }
}