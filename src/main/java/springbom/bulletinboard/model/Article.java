package springbom.bulletinboard.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "ARTICLE_SEQ_GENERATOR",
        sequenceName = "ARTICLE_SEQ",
        initialValue = 3,
        allocationSize = 1)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ARTICLE_SEQ_GENERATOR")
    private long id;

    @CreationTimestamp
    private LocalDateTime createDate;
    private String title;
    private String contents;

    // 비즈니스 로직을 위한 임시 필드
    @Transient
    private int value;

    protected Article() {
    }

    @Builder
    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
