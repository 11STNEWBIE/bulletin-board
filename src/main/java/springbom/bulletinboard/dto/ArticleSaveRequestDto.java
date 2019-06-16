package springbom.bulletinboard.dto;

import springbom.bulletinboard.model.Article;

public class ArticleSaveRequestDto {

    private String title;
    private String contents;

    public ArticleSaveRequestDto() {
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

    public ArticleSaveRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Article toEntity() {
        return new Article(title, contents);
    }

}
