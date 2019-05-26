package com.newbie.bulletinboard.domain.services.members;

import com.newbie.bulletinboard.domain.repositories.members.MemberMapper;
import com.newbie.bulletinboard.domain.repositories.members.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
}
