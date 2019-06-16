package com.newbie.bulletinboard.domain.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostNotFoundException extends Throwable {
    public PostNotFoundException(Long postId) {
        log.info("Post Not Found Exception ::: " + postId);
    }
}
