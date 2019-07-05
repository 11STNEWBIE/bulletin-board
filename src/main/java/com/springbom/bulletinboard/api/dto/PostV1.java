package com.springbom.bulletinboard.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PostV1 {
    private Long id;

    private String title;

    private String content;

    private String author;

    private Date createDate;

    private Date updateDate;
}
