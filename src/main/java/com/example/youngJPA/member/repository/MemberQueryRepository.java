package com.example.youngJPA.member.repository;

import com.example.youngJPA.member.entity.Member;

import java.util.List;

public interface MemberQueryRepository {
    List<Member> findAll();


    Member findOne(Long memberId);

    Long count();
}
