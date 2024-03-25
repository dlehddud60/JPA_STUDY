package com.example.youngJPA.member.service.impl;

//import com.example.youngJPA.locker.domain.Locker;
import com.example.youngJPA.locker.domain.Locker;
import com.example.youngJPA.locker.model.FindResponseLockerModel;
import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.model.FindResponseMemberModel;
import com.example.youngJPA.team.domain.Team;
import com.example.youngJPA.member.repository.MemberRepository;
import com.example.youngJPA.member.service.MemberService;
import com.example.youngJPA.team.model.FindResponseTeamModel;
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
    public void save() {
        Team team = Team.builder()
                .name("개발 1팀")
                .build();
        em.persist(team);

        Locker locker = Locker.builder()
                .name("개인라커")
                .build();
        em.persist(locker);

        Member member = Member.builder()
                .id("dlehddud60")
                .pw("ehd12")
                .team(team)
                .locker(locker)
                .build();
        em.persist(member);
    }

    @Override
    public FindResponseMemberModel findByMemberId(Long memberId) {

        Member member = memberRepository.findById(memberId).get();

        FindResponseTeamModel teamModel = new FindResponseTeamModel(member.getTeam().getTeamId(),member.getTeam().getName());

        FindResponseLockerModel lockerModel = new FindResponseLockerModel(member.getLocker().getLockerId(),member.getLocker().getName());

        FindResponseMemberModel memberModel = new FindResponseMemberModel(member.getMemberId(),member.getId(),member.getPw(),teamModel,lockerModel);
        log.info("========memberModel======={}",memberModel);


        return memberModel;
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
