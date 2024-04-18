package com.example.youngJPA.locker.model;

import com.example.youngJPA.member.model.FindResponseMemberWithLockerModel;
import jakarta.persistence.Column;

public record FindResponseLockerModel(
        Long lockerId,
        String name,
        FindResponseMemberWithLockerModel findResponseMemberWithLockerModel
) {
}

