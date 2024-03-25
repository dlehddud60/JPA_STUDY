package com.example.youngJPA.team.service;

import com.example.youngJPA.team.model.FindResponseTeamListModel;
import com.example.youngJPA.team.model.FindResponseTeamModel;

import java.util.List;

public interface TeamService {
    void save();

    FindResponseTeamModel findByTeamId(Long teamId);

    List<FindResponseTeamListModel> findAll();

    void delete(Long teamId);
}
