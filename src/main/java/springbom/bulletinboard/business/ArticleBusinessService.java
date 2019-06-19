package springbom.bulletinboard.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbom.bulletinboard.data.ArticleRepository;
import springbom.bulletinboard.dto.ArticleSaveRequestDto;
import springbom.bulletinboard.model.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // TODO: add not found Exception, use DTO
    public Article findArticle(long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Long addArticle(ArticleSaveRequestDto dto) {
        return repository.save(dto.toEntity()).getId();
    }

    // TODO: Exception, response type
    @Transactional
    public void updateArticle(Long id, ArticleSaveRequestDto dto) {
        Article articleToUpdate = repository.findById(id).get();
        articleToUpdate.setTitle(dto.getTitle());
        articleToUpdate.setContents(dto.getContents());

        repository.save(articleToUpdate);
    }

    public Map<String, Object> getFormAttribute(Long id) {
        Map<String, Object> attributeMap = new HashMap<>();

        if (id == null) {
            attributeMap.put("pageTitle", "글쓰기");
        } else {
            Article article = findArticle(id);
            attributeMap.put("article", article);
            attributeMap.put("pageTitle", "수정하기");
        }

        return attributeMap;
    }

    // TODO: Exception, response type
    public void deleteArticle(Long id) {
        repository.delete(findArticle(id));
    }
}
