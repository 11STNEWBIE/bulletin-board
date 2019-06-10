package pal.study.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String home() {
        return "/home";
    }

    @GetMapping("/login/form")
    public String loginForm() {
        return "/loginForm";
    }

    @GetMapping("/join/form")
    public String joinForm() {
        return "/joinForm";
    }

    @GetMapping("/post/form")
    public String postForm() {
        return "/postForm";
    }
}
