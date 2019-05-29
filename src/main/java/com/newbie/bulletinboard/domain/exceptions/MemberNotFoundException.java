package com.newbie.bulletinboard.domain.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberNotFoundException extends Throwable {
    public MemberNotFoundException(String memId) {
        log.info("Member ID not Found Exception  ::  " + memId);
    }
}
