package com.newbie.bulletinboard.web.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.services.members.MemberService;
import com.newbie.bulletinboard.domain.services.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Controller("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final MemberService memberService;

    @PutMapping("/insert")
    public @ResponseBody PostDTO insertPosts(@ModelAttribute("posts") PostDTO postDTO) {
        return postService.insertPost(postDTO);
    }

    @GetMapping("/lists/all")
    public @ResponseBody List<PostDTO> getAllPosts(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                   @RequestParam(value = "size", required = false, defaultValue = "10") @Min(1) @Max(20) int size) {
        return postService.getPostList(page, size);
    }
}
