package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MemberDAOTest {

    @Autowired
    MemberDAO memberDAO;

    @Before
    public void setUp() throws Exception {
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
    public void getMemberInformation() {
    }

    @Test
    public void insertMember() throws MemberIdDuplicateMemberIdException {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemId("jjjj");
        memberVO.setMemName("jjjj");

        MemberVO memberVO1 = memberDAO.insertMember(memberVO);
        assertThat(memberVO1).isNotNull();
    }

    @Test
    public void updateMember() {
    }
}