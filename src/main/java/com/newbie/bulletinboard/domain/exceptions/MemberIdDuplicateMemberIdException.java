package com.newbie.bulletinboard.domain.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberIdDuplicateMemberIdException extends Throwable {
    public MemberIdDuplicateMemberIdException(String memId) {
        log.info("Duplicate Member ID :: " + memId);
    }
}
