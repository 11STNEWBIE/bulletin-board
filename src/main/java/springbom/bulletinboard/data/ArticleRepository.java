package springbom.bulletinboard.data;

import org.springframework.data.jpa.repository.JpaRepository;
import springbom.bulletinboard.model.Article;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findById(long id);
}
