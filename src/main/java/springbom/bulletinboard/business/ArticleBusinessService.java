package springbom.bulletinboard.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbom.bulletinboard.data.ArticleRepository;
import springbom.bulletinboard.model.Article;

import java.util.List;

@Component
public class ArticleBusinessService {

    @Autowired
    ArticleRepository repository;

    public List<Article> retrieveAllArticles() {
        // 이곳에 비즈니스 로직을 추가할 수 있다
        return repository.findAll();
    }
}
