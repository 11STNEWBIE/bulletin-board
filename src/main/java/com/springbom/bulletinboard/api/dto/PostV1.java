package com.springbom.bulletinboard.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostV1 {
    private Long id;

    private String title;

    private String content;

    private String author;

    private Date createDate;

    private Date updateDate;
}
