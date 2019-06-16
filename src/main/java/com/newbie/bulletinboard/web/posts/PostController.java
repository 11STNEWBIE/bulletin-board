package com.newbie.bulletinboard.web.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;
import com.newbie.bulletinboard.domain.services.members.MemberService;
import com.newbie.bulletinboard.domain.services.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final MemberService memberService;

    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public @ResponseBody
    PostDTO insertPosts(@ModelAttribute("posts") PostDTO postDTO) {
        return postService.insertPost(postDTO);
    }

    @RequestMapping(value = "/lists/all", method = RequestMethod.GET)
    public @ResponseBody
    List<PostDTO> getAllPosts(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(value = "size", required = false, defaultValue = "10") @Min(1) @Max(20) int size) {
        return postService.getPostList(page, size);
    }

    @RequestMapping(value = "/posts/{postId}/information", method = RequestMethod.GET)
    public @ResponseBody
    PostDTO getPosts(@PathVariable("postId") Long postId) throws PostNotFoundException {
        var postDTO = new PostDTO();
        postDTO.setPostId(postId);
        return postService.getPost(postDTO);
    }

    @RequestMapping(value = "/posts/delete/{postId}", method = RequestMethod.DELETE)
    public @ResponseBody
    PostDTO deletePosts(@PathVariable("postId") Long postId) throws PostNotFoundException {
        var postDTO = new PostDTO();
        postDTO.setPostId(postId);
        return postService.deletePosts(postDTO);
    }

    @RequestMapping("/views/lists")
    public String listView(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
                           Model model) {
        model.addAttribute("posts", postService.getPostList(page, pageSize));
        return "views";
    }

    @RequestMapping("/views/update")
    public String updateView(@RequestParam("postId") long postId,
                             Model model) throws PostNotFoundException {
        var postDTO = new PostDTO();

        postDTO.setPostId(postId);
        model.addAttribute("post", postService.getPost(postDTO));

        return "post";
    }

    @RequestMapping("/views/insert")
    public String insertView() {
        return "insert";
    }

    @RequestMapping("/views/post")
    public String postView(@RequestParam("postId") long postId, Model model) throws PostNotFoundException {
        var postDTO = new PostDTO();
        postDTO.setPostId(postId);

        model.addAttribute("post", postService.getPost(postDTO));

        return "post";
    }
}
