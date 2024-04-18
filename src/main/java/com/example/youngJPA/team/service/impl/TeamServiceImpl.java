package com.example.youngJPA.team.service.impl;

import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.model.FindResponseMemberWithTeamListModel;
import com.example.youngJPA.member.model.FindResponseMemberWithTeamModel;
import com.example.youngJPA.team.domain.Team;
import com.example.youngJPA.team.model.FindResponseTeamListModel;
import com.example.youngJPA.team.model.FindResponseTeamModel;
import com.example.youngJPA.team.model.FindResponseTeamWithMemberModel;
import com.example.youngJPA.team.repository.TeamRepository;
import com.example.youngJPA.team.service.TeamService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final EntityManager em;

    @Override
    public void save() {
        Team team = Team.builder()
                .name("개발2팀")
                .build();

        em.persist(team);
    }

    @Override
    public FindResponseTeamModel findByTeamId(Long teamId) {
        Team team = em.find(Team.class, teamId);
        List<Member> members = team.getMembers();
        List<FindResponseMemberWithTeamModel> findResponseMemberWithTeamModels = new ArrayList<>();
        for (Member member : members) {
            findResponseMemberWithTeamModels.add(new FindResponseMemberWithTeamModel(member.getMemberId(),member.getId(),member.getPw()));
        }
        FindResponseTeamModel findResponseTeamModel = new FindResponseTeamModel(teamId,team.getName(),findResponseMemberWithTeamModels);
        return findResponseTeamModel;
    }

    @Override
    public List<FindResponseTeamListModel> findAll() {
        List<Team> list = teamRepository.findAll();
        List<FindResponseTeamListModel> findResponseTeamModel = new ArrayList<>();
        for (Team team : list) {
            List<Member> members = team.getMembers();
            List<FindResponseMemberWithTeamListModel> findResponseMemberWithTeamListModels = new ArrayList<>();
            for (Member member : members) {
                findResponseMemberWithTeamListModels.add(new FindResponseMemberWithTeamListModel(member.getMemberId(),member.getId(),member.getPw()));
            }

            findResponseTeamModel.add(new FindResponseTeamListModel(team.getTeamId(),team.getName(),findResponseMemberWithTeamListModels));
        }
        return findResponseTeamModel;
    }

    @Override
    public void delete(Long teamId) {
        Team team = em.find(Team.class, teamId);
        em.remove(team);
    }
}
