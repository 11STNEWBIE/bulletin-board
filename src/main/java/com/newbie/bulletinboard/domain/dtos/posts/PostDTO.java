package com.newbie.bulletinboard.domain.dtos.posts;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POST")
@Data
public class PostDTO {
    @Column(name = "POST_ID")
    @Id
    @GeneratedValue
    private Long postId;

    @Column(name = "POST_CONTENT", columnDefinition = "text")
    private String postContent;

    @Column(name = "CREATE_DT")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "CREATE_ID")
    private Long createId;

    @Column(name = "UPDATE_ID")
    private Long updateId;

    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATE_DT")
    private Date updateDate;
}
