package com.newbie.bulletinboard.web.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void joinMembers() {
        var memberDTO = new MemberDTO();
        memberDTO.setMemId("aaaaaaaaa");
        memberDTO.setMemName("zzzzzzzzz");

        var request = new HttpEntity<MemberDTO>(memberDTO);
        testRestTemplate.put("/members/join", request, MemberDTO.class);
    }
}