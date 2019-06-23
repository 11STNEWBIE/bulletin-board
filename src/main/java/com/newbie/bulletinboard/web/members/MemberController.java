package com.newbie.bulletinboard.web.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import com.newbie.bulletinboard.domain.services.members.MemberService;
import com.newbie.bulletinboard.domain.services.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/member")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;

    @PutMapping("/join")
    public MemberDTO joinMembers(@RequestParam("member") MemberDTO memberDTO) {
        return memberService.joinMember(memberDTO);
    }

}
