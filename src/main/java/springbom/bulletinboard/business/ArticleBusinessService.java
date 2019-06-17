package springbom.bulletinboard.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbom.bulletinboard.data.ArticleRepository;
import springbom.bulletinboard.dto.ArticleSaveRequestDto;
import springbom.bulletinboard.model.Article;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleBusinessService {

    private final ArticleRepository repository;

    public ArticleBusinessService(ArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> retrieveAllArticles() {
        // 이곳에 비즈니스 로직을 추가할 수 있다
        return repository.findAll();
    }

    public Optional<Article> findArticle(long id) {
        return repository.findById(id);
    }

    @Transactional
    public Long addArticle(ArticleSaveRequestDto dto) {
        return repository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void updateArticle(Long id, ArticleSaveRequestDto dto) {
        Article articleToUpdate = repository.findById(id).get();
        articleToUpdate.setTitle(dto.getTitle());
        articleToUpdate.setContents(dto.getContents());

        repository.save(articleToUpdate);
    }
}
