package com.newbie.bulletinboard.web.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.services.members.MemberService;
import com.newbie.bulletinboard.domain.services.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;

    @PutMapping(value = "/join")
    public MemberDTO joinMembers(@RequestBody MemberDTO memberDTO) {
        return memberService.joinMember(memberDTO);
    }

}
