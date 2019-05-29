package com.newbie.bulletinboard.web.posts;

import com.newbie.bulletinboard.domain.services.members.MemberService;
import com.newbie.bulletinboard.domain.services.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final MemberService memberService;
}
