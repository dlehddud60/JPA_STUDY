package com.example.youngJPA.member.service;

import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.model.FindResponseMemberModel;

import java.util.List;

public interface MemberService {

    void save();

    FindResponseMemberModel findByMemberId(Long memberId);

    List<Member> findAll();

    void delete(Long memberId);
}
