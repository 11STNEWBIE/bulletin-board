package com.newbie.bulletinboard.domain.services.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;
import com.newbie.bulletinboard.domain.repositories.posts.PostDAO;
import com.newbie.bulletinboard.domain.repositories.posts.PostVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Autowired
    PostDAO postDAO;

    private PostVO postVOs;
    @Before
    public void setUp() {
        PostVO postVO = new PostVO();
        postVO.setPostContent("TESTSSSSSS");
        postVOs = postDAO.insertPost(postVO);
    }

    @Test
    public void insertPost() {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostContent("TESTSSSSSS2");
        postService.insertPost(postDTO);
    }

    @Test
    public void getPost() throws PostNotFoundException {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postVOs.getPostId());
        PostDTO post = postService.getPost(postDTO);
        assertNotNull(post);
    }

    @Test
    public void updatePostContent() throws PostNotFoundException, Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postVOs.getPostId());
        PostDTO post = postService.getPost(postDTO);
        post.setPostContent("TTTTTTBBB");

        PostDTO postDTOss = postService.updatePostContent(post);
        System.out.println(postDTOss.toString());
        assertNotNull(postDTOss);
        assertEquals("TTTTTTBBB", postDTOss.getPostContent());
    }
}