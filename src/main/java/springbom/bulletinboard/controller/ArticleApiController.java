package springbom.bulletinboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbom.bulletinboard.business.ArticleBusinessService;
import springbom.bulletinboard.dto.ArticleSaveRequestDto;
import springbom.bulletinboard.model.Article;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleApiController {

    private final ArticleBusinessService businessService;

    public ArticleApiController(ArticleBusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/all")
    public List<Article> retrieveAllArticles() {
        return businessService.retrieveAllArticles();
    }

    @PostMapping("/add")
    public Long add(@RequestBody ArticleSaveRequestDto dto) {
        return businessService.addArticle(dto);
    }

}
