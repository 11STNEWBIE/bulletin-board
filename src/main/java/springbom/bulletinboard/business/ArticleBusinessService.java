package springbom.bulletinboard.business;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springbom.bulletinboard.data.ArticleRepository;
import springbom.bulletinboard.dto.ArticleSaveRequestDto;
import springbom.bulletinboard.model.Article;

import java.util.List;

@Component
public class ArticleBusinessService {

    private ArticleRepository repository;

    public ArticleBusinessService(ArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> retrieveAllArticles() {
        // 이곳에 비즈니스 로직을 추가할 수 있다
        return repository.findAll();
    }

    @Transactional
    public Article addArticle(Article article) {
        return repository.saveAndFlush(article);
    }

    @Transactional
    public Long addByDto(ArticleSaveRequestDto dto) {
        return repository.save(dto.toEntity()).getId();
    }

}
