package com.example.youngJPA.team.model;

import com.example.youngJPA.member.model.FindResponseMemberWithTeamModel;
import jakarta.persistence.Column;

import java.util.List;

public record FindResponseTeamModel(
        Long teamId,
        String name,
        List<FindResponseMemberWithTeamModel> findResponseMemberWithTeamModels
) {

}
