package com.example.youngJPA.member.service.impl;

//import com.example.youngJPA.locker.domain.Locker;
import com.example.youngJPA.locker.entity.Locker;
import com.example.youngJPA.locker.model.FindResponseLockerWithMemberListModel;
import com.example.youngJPA.locker.model.FindResponseLockerWithMemberModel;
import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.model.FindResponseMemberListModel;
import com.example.youngJPA.member.model.FindResponseMemberModel;
import com.example.youngJPA.member.model.FindResponseQMemberModel;
import com.example.youngJPA.member.repository.MemberQueryRepository;
import com.example.youngJPA.team.entity.Team;
import com.example.youngJPA.member.repository.MemberRepository;
import com.example.youngJPA.member.service.MemberService;
import com.example.youngJPA.team.model.FindResponseTeamWithMemberListModel;
import com.example.youngJPA.team.model.FindResponseTeamWithMemberModel;
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
    private final MemberQueryRepository memberQueryRepository;
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



        FindResponseTeamWithMemberModel teamModel = new FindResponseTeamWithMemberModel(member.getTeam().getTeamId(),member.getTeam().getName());

        FindResponseLockerWithMemberModel lockerModel = new FindResponseLockerWithMemberModel(member.getLocker().getLockerId(),member.getLocker().getName());

        FindResponseMemberModel memberModel = new FindResponseMemberModel(member.getMemberId(),member.getId(),member.getPw(),teamModel,lockerModel);
        log.info("========memberModel======={}",memberModel);


        return memberModel;
    }

    @Override
    public  List<FindResponseMemberListModel> findAll() {
        List<Member> list = memberRepository.findAll();
        List<Member> list1 = memberQueryRepository.findAll();
        for (Member member : list1) {
            log.info("===========member=============={}",member);
        }
        List<FindResponseMemberListModel> findResponseMemberListModels = new ArrayList<>();
        for (Member member : list1) {
            Team team = member.getTeam();
            Locker locker = member.getLocker();
            FindResponseTeamWithMemberListModel findResponseLockerWithTeamListModel = new FindResponseTeamWithMemberListModel(team.getTeamId(),team.getName());
            FindResponseLockerWithMemberListModel findResponseLockerWithMemberListModel = new FindResponseLockerWithMemberListModel(locker.getLockerId(),locker.getName());
            findResponseMemberListModels.add(new FindResponseMemberListModel(member.getMemberId(),member.getId(),member.getPw(),findResponseLockerWithTeamListModel,findResponseLockerWithMemberListModel));
        }
        return findResponseMemberListModels;
    }

    @Override
    public void delete(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    public Long count() {
        return memberQueryRepository.count();
    }

    @Override
    public FindResponseQMemberModel findQ(Long memberId) {
        Member one = memberQueryRepository.findOne(memberId);
        FindResponseQMemberModel findResponseQMemberModel = new FindResponseQMemberModel(one.getMemberId(),one.getId(),one.getPw());

        return findResponseQMemberModel;
    }
}
