package com.example.youngJPA.team.service.impl;

import com.example.youngJPA.team.domain.Team;
import com.example.youngJPA.team.model.FindResponseTeamListModel;
import com.example.youngJPA.team.model.FindResponseTeamModel;
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
        FindResponseTeamModel findResponseTeamModel = new FindResponseTeamModel(teamId,team.getName());
        return findResponseTeamModel;
    }

    @Override
    public List<FindResponseTeamListModel> findAll() {
        List<Team> list = teamRepository.findAll();
        List<FindResponseTeamListModel> findResponseTeamModel = new ArrayList<>();
        for (Team team : list) {
            findResponseTeamModel.add(new FindResponseTeamListModel(team.getTeamId(),team.getName()));
        }
        return findResponseTeamModel;
    }

    @Override
    public void delete(Long teamId) {
        Team team = em.find(Team.class, teamId);
        em.remove(team);
    }
}
