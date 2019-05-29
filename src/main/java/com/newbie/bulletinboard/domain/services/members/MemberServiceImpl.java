package com.newbie.bulletinboard.domain.services.members;

import com.newbie.bulletinboard.domain.repositories.members.MemberDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

}
