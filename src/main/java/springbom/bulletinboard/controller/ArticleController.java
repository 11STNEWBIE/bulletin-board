package springbom.bulletinboard.controller;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import springbom.bulletinboard.business.ArticleBusinessService;
import springbom.bulletinboard.model.Article;

@Controller
public class ArticleController {

    private final ArticleBusinessService businessService;

    public ArticleController(ArticleBusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    // TODO: add not found page, use DTO
    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable("id") long id,
                             Model model) {
        Article article = businessService.findArticle(id).get();
        model.addAttribute("article", article);

        return "articleDetail";
    }

    @GetMapping("/article/form")
    public String articleForm(@RequestParam(value = "id", required = false) Long id,
                              Model model) {
        if (id == null) {
            model.addAttribute("pageTitle", "글쓰기");
        } else {
            Article article = businessService.findArticle(id).get();
            model.addAttribute("article", article);
            model.addAttribute("pageTitle", "수정하기");
        }

        return "form";
    }
}
