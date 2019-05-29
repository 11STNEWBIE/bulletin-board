package com.newbie.bulletinboard.web.members;

import com.newbie.bulletinboard.domain.services.members.MemberService;
import com.newbie.bulletinboard.domain.services.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;
}
