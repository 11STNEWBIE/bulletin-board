package com.springbom.bulletinboard.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long postId) {
        log.info("Post Not Found Exception : " + postId);
    }
}
