package com.example.youngJPA.board.repository;

import com.example.youngJPA.board.model.FindResponseBoardListModel;
import com.example.youngJPA.board.model.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardQueryRepository {
    Page<FindResponseBoardListModel> findAllByQueryDsl(SearchCondition searchCondition, Pageable pageable);
}
