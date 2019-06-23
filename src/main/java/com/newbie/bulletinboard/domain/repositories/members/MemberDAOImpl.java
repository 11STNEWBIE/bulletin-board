package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@AllArgsConstructor
public class MemberDAOImpl implements MemberDAO {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberVO getMemberInformation(MemberVO memberVO) throws MemberNotFoundException {
        return memberRepository.findByMemId(memberVO.getMemId())
                .orElseThrow(() -> new MemberNotFoundException(memberVO.getMemId()));
    }

    @Override
    public MemberVO insertMember(MemberVO memberVO) throws MemberIdDuplicateMemberIdException {
        var byMemId = memberRepository.findByMemId(memberVO.getMemId());

        if (byMemId.isPresent())
            throw new MemberIdDuplicateMemberIdException(memberVO.getMemId());

        memberVO.setCreateDate(new Date());

        return memberRepository.save(memberVO);
    }

    @Override
    public MemberVO updateMember(MemberVO memberVO) throws MemberNotFoundException {
        var byMemId = memberRepository.findByMemId(memberVO.getMemId());

        byMemId.orElseThrow(() -> new MemberNotFoundException(memberVO.getMemId()));
        memberVO.setUpdateDate(new Date());

        return memberRepository.save(memberVO);
    }

    @Override
    public int memberNameUpdate(MemberVO memberVO) throws MemberNotFoundException {
        var byMemId = memberRepository.findByMemId(memberVO.getMemId());

        var savedMember = byMemId.orElseThrow(() -> new MemberNotFoundException(memberVO.getMemId()));
        memberVO.setMemSeq(savedMember.getMemSeq());
        memberVO.setUpdateDate(new Date());

        return memberMapper.memberNameUpdate(memberVO);
    }

    @Override
    public int memberStatusUpdate(MemberVO memberVO) throws MemberNotFoundException {
        var byMemId = memberRepository.findByMemId(memberVO.getMemId());

        var savedMember = byMemId.orElseThrow(() -> new MemberNotFoundException(memberVO.getMemId()));
        memberVO.setMemSeq(savedMember.getMemSeq());
        memberVO.setUpdateDate(new Date());

        return memberMapper.memberStatusUpdate(memberVO);
    }
}
