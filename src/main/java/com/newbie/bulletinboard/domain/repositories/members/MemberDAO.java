package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;

public interface MemberDAO {
    MemberDTO getMemberInformation(MemberDTO memberDTO) throws MemberNotFoundException;
    MemberDTO insertMember(MemberDTO memberDTO) throws MemberIdDuplicateMemberIdException;
    MemberDTO updateMember(MemberDTO memberDTO) throws MemberNotFoundException;
}
