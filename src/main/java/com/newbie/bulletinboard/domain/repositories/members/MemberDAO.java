package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;

public interface MemberDAO {
    MemberVO getMemberInformation(MemberVO MemberVO) throws MemberNotFoundException;

    MemberVO insertMember(MemberVO MemberVO) throws MemberIdDuplicateMemberIdException;

    MemberVO updateMember(MemberVO MemberVO) throws MemberNotFoundException;

    int memberStatusUpdate(MemberVO MemberVO) throws MemberNotFoundException;

    int memberNameUpdate(MemberVO MemberVO) throws MemberNotFoundException;
}
