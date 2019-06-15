package springbom.bulletinboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springbom.bulletinboard.business.ArticleBusinessService;
import springbom.bulletinboard.model.Article;

import java.util.List;

@RestController
public class ArticleApiController {

    private ArticleBusinessService businessService;

    public ArticleApiController(ArticleBusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/")
    public String home() {
        return "This is home";
    }

    @GetMapping("/articles")
    public List<Article> retrieveAllArticles() {
        return businessService.retrieveAllArticles();
    }

    @PostMapping("/add")
    public Article addArticle(@ModelAttribute("article") Article article) {
        return businessService.addArticle(article);
    }

}
