package com.newbie.bulletinboard.domain.dtos.members;

public enum MemberStatus {
    AUTHORIZED("01", "인증된 상태"),
    UNAUTHORIZED("02", "미인증 상태");

    private String code;
    private String codeDescription;

    MemberStatus(String code, String codeDescription) {
        this.code = code;
        this.codeDescription = codeDescription;
    }

    public String getCode() {
        return code;
    }

    public String getCodeDescription() {
        return codeDescription;
    }
}
