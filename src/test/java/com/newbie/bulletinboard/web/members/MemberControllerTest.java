package com.newbie.bulletinboard.web.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
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

        var httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

        var request = new HttpEntity<>(memberDTO, httpHeaders);
        var exchange = testRestTemplate.exchange("/members/join", HttpMethod.PUT, request, MemberDTO.class);
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}