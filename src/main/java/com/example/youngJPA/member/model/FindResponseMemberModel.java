package com.example.youngJPA.member.model;

import com.example.youngJPA.locker.model.FindResponseLockerModel;
import com.example.youngJPA.team.domain.Team;
import com.example.youngJPA.team.model.FindResponseTeamModel;

public record FindResponseMemberModel(
        Long memberId,
        String id,
        String pw,
        FindResponseTeamModel team,
        FindResponseLockerModel locker
) {
}
