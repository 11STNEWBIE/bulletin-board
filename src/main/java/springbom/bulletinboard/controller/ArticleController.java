package springbom.bulletinboard.controller;

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

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable("id") Long id, Model model){
        Article article = businessService.findArticle(id);
        model.addAttribute("article", article);

        return "articleDetail";
    }

    @GetMapping("/article/form")
    public String articleForm(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAllAttributes(businessService.getFormAttribute(id));

        return "form";
    }
}
