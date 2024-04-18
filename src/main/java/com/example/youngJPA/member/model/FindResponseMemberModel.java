package com.example.youngJPA.member.model;

import com.example.youngJPA.locker.model.FindResponseLockerModel;
import com.example.youngJPA.locker.model.FindResponseLockerWithMemberModel;
import com.example.youngJPA.team.domain.Team;
import com.example.youngJPA.team.model.FindResponseTeamModel;
import com.example.youngJPA.team.model.FindResponseTeamWithMemberModel;

public record FindResponseMemberModel(
        Long memberId,
        String id,
        String pw,
        FindResponseTeamWithMemberModel teamModel,
        FindResponseLockerWithMemberModel lockerModel
) {
}
