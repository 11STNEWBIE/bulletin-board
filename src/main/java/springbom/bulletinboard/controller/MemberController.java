package springbom.bulletinboard.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springbom.bulletinboard.data.MemberRepository;
import springbom.bulletinboard.model.Member;
import springbom.bulletinboard.model.MemberRole;

import java.util.Arrays;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    // TODO: use DTO
    @PostMapping("/member")
    public String create(Member member) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        MemberRole role = new MemberRole();
        role.setRoleName("BASIC");
        member.setRoles(Arrays.asList(role));

        memberRepository.save(member);

        return "redirect:/";
    }
}