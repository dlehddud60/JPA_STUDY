package com.example.youngJPA.member.model;

public record FindResponseMemberWithLockerModel(
        Long memberId,
        String id,
        String pw
) {
}
