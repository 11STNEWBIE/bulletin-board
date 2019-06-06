package com.newbie.bulletinboard.domain.services.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;
import com.newbie.bulletinboard.domain.repositories.members.MemberDAO;
import com.newbie.bulletinboard.domain.repositories.members.MemberVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberDAO memberDAO;

    @Before
    public void setUp() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemId("juwon");
        memberVO.setMemName("juwon");
        try {
            memberDAO.insertMember(memberVO);
        } catch (MemberIdDuplicateMemberIdException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMemberInformation() throws MemberNotFoundException {
        MemberDTO juwon = memberService.getMemberInformation("juwon");
        assertNotNull(juwon);
    }
}