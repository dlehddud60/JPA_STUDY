package com.example.youngJPA.member.model;

import com.example.youngJPA.locker.model.FindResponseLockerWithMemberListModel;
import com.example.youngJPA.team.model.FindResponseTeamWithMemberListModel;

public record FindResponseMemberListModel(
        Long memberId,
        String id,
        String pw,
        FindResponseTeamWithMemberListModel findResponseLockerWithTeamListModel,
        FindResponseLockerWithMemberListModel findResponseLockerWithMemberListModel
) {
}
