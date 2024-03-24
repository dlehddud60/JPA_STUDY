package com.example.youngJPA.member.service.impl;

//import com.example.youngJPA.locker.domain.Locker;
import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.team.domain.Team;
import com.example.youngJPA.member.repository.MemberRepository;
import com.example.youngJPA.member.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final EntityManager em;
    @Override
    public void save(Member member) {
        log.info("============save start================");

        //팀 저장
        Team team = Team.builder()
                .name("개발1팀")
                .members(new ArrayList<>())
                .build();
        em.persist(team);
        log.info("==========team1==========={}",team);
//
//        //락커 저장
//        Locker locker = Locker.builder()
//                .name("이동영 개인 라커")
//                .build();
//        em.persist(locker);

        //회원 저장
        member.setTeam(team);
        team.getMembers().add(member);
        em.persist(member);
        Member member1 = em.find(Member.class, 1);
        member1.getTeam().getMembers().stream()
                        .forEach(log::info);
        log.info("==========team2==========={}",team);
        log.info("===========member=============={}",member);
        log.info("============save end================");

    }

    @Override
    public Member findByMemberId(Long memberId) {

        Member member = em.find(Member.class, memberId);
        log.info("============findByMemberId============={}",member);

        Team findTeam = member.getTeam();
        log.info("==========findTeam=========={}",findTeam);

        return member;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void delete(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
