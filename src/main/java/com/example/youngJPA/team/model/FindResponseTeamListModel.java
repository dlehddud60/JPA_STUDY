package com.example.youngJPA.team.model;

import com.example.youngJPA.member.model.FindResponseMemberWithTeamListModel;

import java.util.List;

public record FindResponseTeamListModel(
        Long teamId,
        String name,
        List<FindResponseMemberWithTeamListModel> findResponseMemberWithTeamListModels
) {

}
