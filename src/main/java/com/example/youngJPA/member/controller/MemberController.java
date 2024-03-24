package com.example.youngJPA.member.controller;

import com.example.youngJPA.member.entity.Auth;
import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/save")
    public void save() {
        Member member = Member.builder()
                .id("LeeDongYoung")
                .pw("ehddud12")
                .build();
        memberService.save(member);

    }

   @GetMapping("/find/{memberId}")
    public Member find(@PathVariable(name = "memberId") Long memberId) {
        return memberService.findByMemberId(memberId);
   }

   @GetMapping
    public List<Member> findAll () {
        return memberService.findAll();
   }
   @GetMapping("/delete/{memberId}")
    public void delete(@PathVariable(name = "memberId") Long memberId) {
        memberService.delete(memberId);
   }
}
