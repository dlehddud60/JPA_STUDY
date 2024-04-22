package com.example.youngJPA.member.repository;

import com.example.youngJPA.member.entity.Member;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.youngJPA.locker.entity.QLocker.*;
import static com.example.youngJPA.member.entity.QMember.member;
import static com.example.youngJPA.team.entity.QTeam.*;

@Log4j2
@Repository
@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository {
    private final JPAQueryFactory queryFactory;



    @Override
    public List<Member> findAll() {

        return queryFactory.selectFrom(member)
                .leftJoin(member.locker, locker)
                .leftJoin(member.team, team)
                .fetchJoin()
                .offset(0)
                .limit(2)
                .fetch();
    }





    @Override
    public Member findOne(Long memberId) {

        return queryFactory.selectFrom(member)
                .where(memId(memberId)).fetchOne();
    }

    private BooleanExpression memId (Long memberId) {
        return memberId != null ? member.memberId.eq(memberId) : null;
    }

    @Override
    public Long count() {
        Long l = queryFactory.select(Wildcard.count).from(member)
                .join(member.locker, locker)
                .fetchOne();
        log.info("=============l==============={}",l);
        return l;
    }
}
