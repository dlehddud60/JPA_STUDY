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
        log.info("================start================");
        em.persist(member);
        em.detach(member); // 준영속 상태
        em.close(); // 영속성 컨텍스트 종료.
        em.clear(); // 영속성 컨텍스트 초기화.
        em.merge(member);
        log.info("===============1111================");
        log.info("================end 쓰기지연에서 flush작업================");
        System.out.println();
    }

    @Override
    public Member findByMemberId(Long memberId) {
        return memberRepository.findById(memberId).get();
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
