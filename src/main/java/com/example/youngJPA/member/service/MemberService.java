package com.example.youngJPA.member.service;

import com.example.youngJPA.member.model.FindResponseMemberListModel;
import com.example.youngJPA.member.model.FindResponseMemberModel;
import com.example.youngJPA.member.model.FindResponseQMemberModel;

import java.util.List;

public interface MemberService {

    void save();

    FindResponseMemberModel findByMemberId(Long memberId);

    List<FindResponseMemberListModel> findAll();

    void delete(Long memberId);

    Long count();

    FindResponseQMemberModel findQ(Long memberId);
}
