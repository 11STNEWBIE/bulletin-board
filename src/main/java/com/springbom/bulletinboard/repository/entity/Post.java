package com.springbom.bulletinboard.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Post extends BaseEntity {

    @Column(length = 500, nullable = false, name = "TITLE")
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false, name = "CONTENT")
    private String content;

    @Column(name="AUTHOR")
    private String author;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
