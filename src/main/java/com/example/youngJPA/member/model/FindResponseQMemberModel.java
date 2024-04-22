package com.example.youngJPA.member.model;

import com.example.youngJPA.locker.model.FindResponseLockerWithMemberModel;
import com.example.youngJPA.team.model.FindResponseTeamWithMemberModel;

public record FindResponseQMemberModel(
        Long memberId,
        String id,
        String pw
) {
}
