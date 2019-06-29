package pal.study.board.dto;

import lombok.Getter;
import pal.study.board.domain.Posts;
import pal.study.board.utils.DateTimeConverter;

@Getter
public class PostsDTO {

    private Long id;
    private String title;
    private String content;
    private String createdDate;

    public PostsDTO() {
    }

    public PostsDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = DateTimeConverter.toStringDateTime(entity.getCreatedDate());
    }

}