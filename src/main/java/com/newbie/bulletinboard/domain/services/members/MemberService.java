package com.newbie.bulletinboard.domain.services.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;

public interface MemberService {

    MemberDTO getMemberInformation(String memberId) throws MemberNotFoundException;

    MemberDTO joinMember(MemberDTO memberDTO);

}
