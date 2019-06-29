package com.newbie.bulletinboard.domain.services.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;
import com.newbie.bulletinboard.domain.repositories.members.MemberDAO;
import com.newbie.bulletinboard.domain.repositories.members.MemberVO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final ModelMapper modelMapper;

    @Override
    public MemberDTO getMemberInformation(String memberId) throws MemberNotFoundException {
        MemberVO memberInformation = new MemberVO();
        memberInformation.setMemId(memberId);

        memberInformation = memberDAO.getMemberInformation(memberInformation);

        return modelMapper.map(memberInformation, MemberDTO.class);
    }

    @Override
    public MemberDTO joinMember(MemberDTO memberDTO) {

        MemberVO memberVO;
        try {
            memberVO = memberDAO.insertMember(modelMapper.map(memberDTO, MemberVO.class));
        } catch (MemberIdDuplicateMemberIdException e) {
            return null;
        }
        return modelMapper.map(memberVO, MemberDTO.class);
    }
}
