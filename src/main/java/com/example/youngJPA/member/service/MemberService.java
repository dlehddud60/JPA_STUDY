package com.example.youngJPA.member.service;

import com.example.youngJPA.member.entity.Member;

import java.util.List;

public interface MemberService {

    void save(Member member);

    Member findByMemberId(Long memberId);

    List<Member> findAll();

    void delete(Long memberId);
}
