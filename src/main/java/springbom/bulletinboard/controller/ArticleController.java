package springbom.bulletinboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/article/form")
    public String createArticle() {
        return "form";
    }
}
