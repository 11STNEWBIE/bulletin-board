package com.newbie.bulletinboard.domain.dtos.members;

import lombok.Data;

import java.util.Date;


@Data
public class MemberDTO {

    private Long memSeq;

    private String memId;

    private String memName;

    private Date createDate;

    private MemberStatus memberStatus = MemberStatus.UNAUTHORIZED;

    private Date updateDate;
}


