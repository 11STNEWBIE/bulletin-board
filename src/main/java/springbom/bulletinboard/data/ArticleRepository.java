package springbom.bulletinboard.data;

import org.springframework.data.jpa.repository.JpaRepository;
import springbom.bulletinboard.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
