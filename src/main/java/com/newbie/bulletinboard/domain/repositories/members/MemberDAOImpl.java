package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MemberDAOImpl implements MemberDAO {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberDTO getMemberInformation(MemberDTO memberDTO) throws MemberNotFoundException {
        return memberRepository.findByMemId(memberDTO.getMemId()).orElseThrow(() -> new MemberNotFoundException(memberDTO.getMemId()));
    }

    @Override
    public MemberDTO insertMember(MemberDTO memberDTO) throws MemberIdDuplicateMemberIdException {
        Optional<MemberDTO> byMemId = memberRepository.findByMemId(memberDTO.getMemId());
        if(byMemId.isPresent()) {
            throw new MemberIdDuplicateMemberIdException(memberDTO.getMemId());
        }
        memberDTO.setCreateDate(new Date());
        return memberRepository.save(memberDTO);
    }

    @Override
    public MemberDTO updateMember(MemberDTO memberDTO) throws MemberNotFoundException {
        Optional<MemberDTO> byMemId = memberRepository.findByMemId(memberDTO.getMemId());
        byMemId.orElseThrow(() -> new MemberNotFoundException(memberDTO.getMemId()));
        memberDTO.setUpdateDate(new Date());
        return memberRepository.save(memberDTO);
    }
}
