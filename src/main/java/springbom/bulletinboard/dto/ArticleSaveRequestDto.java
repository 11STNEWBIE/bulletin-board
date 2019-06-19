package springbom.bulletinboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springbom.bulletinboard.model.Article;

@Getter
@Setter
public class ArticleSaveRequestDto {

    private String title;
    private String contents;

    public ArticleSaveRequestDto() {
    }

    @Builder
    public ArticleSaveRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .contents(contents)
                .build();
    }

}
