package com.newbie.bulletinboard.domain.dtos.members;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class MemberDTO implements Serializable {

    private Long memSeq;

    private String memId;

    private String memName;

    private Date createDate;

    private MemberStatus memberStatus = MemberStatus.UNAUTHORIZED;

    private Date updateDate;
}


