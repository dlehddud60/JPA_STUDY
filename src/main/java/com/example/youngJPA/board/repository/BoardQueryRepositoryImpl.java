package com.example.youngJPA.board.repository;

import com.example.youngJPA.board.entity.Board;
import com.example.youngJPA.board.model.FindResponseBoardListModel;
import com.example.youngJPA.board.model.SearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.youngJPA.board.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepositoryImpl implements BoardQueryRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<FindResponseBoardListModel> findAllByQueryDsl(SearchCondition searchCondition, Pageable pageable) {
        List<Board> list = queryFactory.selectFrom(board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(search(searchCondition.searchValue()))
                .orderBy(board.boardId.desc())
                .fetch();
        List<FindResponseBoardListModel> pageList = new ArrayList<>();
        for (Board board : list) {
            pageList.add(new FindResponseBoardListModel(
                    board.getBoardId(),
                    board.getBoardTitle(),
                    board.getBoardText(),
                    board.getBoardInputDt(),
                    board.getBoardUpdateDt()
                    ));
        }
        JPAQuery<Long> count = queryFactory.select(Wildcard.count).from(board);
        return PageableExecutionUtils.getPage(pageList,pageable,count::fetchOne);
    }
    private BooleanExpression search(String searchVelue) {
        return searchVelue != null ? board.boardTitle.contains(searchVelue) : null;
    }
}
