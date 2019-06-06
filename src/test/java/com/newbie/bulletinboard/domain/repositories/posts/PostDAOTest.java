package com.newbie.bulletinboard.domain.repositories.posts;

import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.MemberNotFoundException;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;
import com.newbie.bulletinboard.domain.repositories.members.MemberDAO;
import com.newbie.bulletinboard.domain.repositories.members.MemberVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PostDAOTest {

    @Autowired
    PostDAO postDAO;

    @Autowired
    MemberDAO memberDAO;

    private PostVO savedPostDTO;
    private MemberVO savedMemberDTO;


    @Before
    public void setup() {
        MemberVO memberDTO = new MemberVO();
        memberDTO.setMemId("juwon");
        memberDTO.setMemName("juwon");
        try {
            savedMemberDTO = memberDAO.insertMember(memberDTO);
        } catch (MemberIdDuplicateMemberIdException ignored) {
            try {
                savedMemberDTO = memberDAO.getMemberInformation(memberDTO);
            } catch (MemberNotFoundException ignoreds) {
                System.out.println(savedMemberDTO.toString());
            }
        }

        PostVO postDTO = new PostVO();
        postDTO.setPostContent("tests");
        postDTO.setCreateId(savedMemberDTO.getMemSeq());
        savedPostDTO = postDAO.insertPost(postDTO);
    }

    @Test
    public void getPostInformation() {
        PostVO postDTO = new PostVO();
        postDTO.setPostId(savedPostDTO.getPostId());
        try {
            postDTO = postDAO.getPostInformation(postDTO);
            System.out.println(postDTO);
        } catch (PostNotFoundException ignored) {
        }
        assertNotNull(savedPostDTO.getCreateId());
        assertNotNull(savedPostDTO.getCreateDate());
        assertNotNull(savedPostDTO.getPostContent());
    }

    @Test
    public void updatePost() throws PostNotFoundException {
        savedPostDTO.setPostContent("TESTSSSSSSS");
        savedPostDTO.setUpdateId(savedMemberDTO.getMemSeq());
        PostVO updateCount = postDAO.updatePost(savedPostDTO);
        assertNotNull(updateCount);

        PostVO postInformation = postDAO.getPostInformation(savedPostDTO);

        assertEquals(postInformation.getPostId(), savedPostDTO.getPostId());
        assertEquals(postInformation.getPostContent(), savedPostDTO.getPostContent());
    }
}