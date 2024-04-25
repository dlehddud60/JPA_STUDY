package com.example.youngJPA.board.service;


import com.example.youngJPA.board.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    List<FindResponseBoardListModel> findAll();

    FindResponseBoardModel findByBoardId(Long boardId);


    void delete(Long boardId);

    void save(FindRequestBoardInsertModel boardModel);

    void update(FindRequestBoardUpdateModel boardUpdateModel);

    Page<FindResponseBoardListModel> findAllByQueryDsl(SearchCondition searchCondition, Pageable pageable);
}


