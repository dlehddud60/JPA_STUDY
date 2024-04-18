package com.example.youngJPA.locker.model;

import com.example.youngJPA.member.model.FindResponseMemberWithLockerListModel;

public record FindResponseLockerListModel(
        Long lockerId,
        String name,
        FindResponseMemberWithLockerListModel findResponseMemberWithLockerListModel
) {
}

