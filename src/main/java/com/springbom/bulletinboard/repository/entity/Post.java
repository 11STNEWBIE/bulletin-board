package com.springbom.bulletinboard.repository.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@NoArgsConstructor
@Getter
@Entity
@Table(name="POST")
public class Post {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false, name = "TITLE")
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false, name = "CONTENT")
    private String content;

    @Column(name="AUTHOR")
    private String author;

    @Column(name = "CREATE_DT")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "UPDATE_DT")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Builder
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
