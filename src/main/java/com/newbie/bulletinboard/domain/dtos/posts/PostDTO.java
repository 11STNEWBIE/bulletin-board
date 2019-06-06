package com.newbie.bulletinboard.domain.dtos.posts;

import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    private Long postId;

    private String postContent;

    private Date createDate;

    private Long createId;

    private Long updateId;

    private Date updateDate;
}
