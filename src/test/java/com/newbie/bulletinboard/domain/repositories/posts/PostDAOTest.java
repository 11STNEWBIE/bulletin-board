package com.newbie.bulletinboard.domain.repositories.posts;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.exceptions.MemberIdDuplicateMemberIdException;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;
import com.newbie.bulletinboard.domain.repositories.members.MemberDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDAOTest {

    @Autowired
    PostDAO postDAO;

    @Autowired
    MemberDAO memberDAO;

    PostDTO savedPostDTO;

    @Before
    public void setup() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemId("juwon");
        memberDTO.setMemName("juwon");
        try {
            memberDTO = memberDAO.insertMember(memberDTO);
        } catch (MemberIdDuplicateMemberIdException e) {
        }

        PostDTO postDTO = new PostDTO();
        postDTO.setPostContent("tests");
        postDTO.setCreateId(memberDTO.getMemSeq());
        savedPostDTO = postDAO.insertPost(postDTO);
    }

    @Test
    public void getPostInformation() {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(savedPostDTO.getPostId());
        try {
            postDTO = postDAO.getPostInformation(postDTO);
            System.out.println(postDTO);
        } catch (PostNotFoundException e) {
        }
        assertNotNull(savedPostDTO.getCreateId());
        assertNotNull(savedPostDTO.getCreateDate());
        assertNotNull(savedPostDTO.getPostContent());
    }

    @Test
    public void updatePost() throws PostNotFoundException {
        savedPostDTO.setPostContent("TESTSSSSSSS");
        PostDTO postDTO = postDAO.updatePost(savedPostDTO);
        assertEquals(postDTO.getPostContent(), "TESTSSSSSSS");
        assertEquals(postDTO.getPostId(), savedPostDTO.getPostId());
    }
}