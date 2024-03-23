package com.example.youngJPA.member.service.impl;

import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.repository.MemberRepository;
import com.example.youngJPA.member.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        System.out.println();
        em.persist(member.getLocker());
        em.persist(member.getTeam());
        member.getTeam().setName("개발1팀");
        member.getLocker().setName("개인로커");
        log.info("================start================");
        em.persist(member);
    }

    @Override
    public Member findByMemberId(Long memberId) {

        Member member = em.find(Member.class, memberId);

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
