package com.example.youngJPA.member.controller;

import com.example.youngJPA.member.entity.Auth;
import com.example.youngJPA.member.entity.Locker;
import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.entity.Team;
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
        Team team = Team.builder().build();
        Locker locker = Locker.builder().build();
        Member member = Member.builder()
                .id("LeeDongYoung")
                .pw("ehddud12")
                .aboutMe("안녕하세요 저는 이동영 입니다. 이번에 XX사이트를 지인을 통해 가입하게 되었습니다. 앞으로도 사이트 활동을 자주 하려고 합니다. 감사합니다.")
                .memberAuth(Auth.USER)
                .memberDt(LocalDate.now())
                .team(team)
                .locker(locker)
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
