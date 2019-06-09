package springbom.bulletinboard.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Entity
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

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
