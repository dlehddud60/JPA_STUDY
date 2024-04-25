package com.example.youngJPA.board.service.impl;

import com.example.youngJPA.board.entity.Board;
import com.example.youngJPA.board.model.*;
import com.example.youngJPA.board.repository.BoardQueryRepository;
import com.example.youngJPA.board.repository.BoardRepository;
import com.example.youngJPA.board.service.BoardService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;
    private final EntityManager em;

    @Override
    public List<FindResponseBoardListModel> findAll() {
        List<Board> all = boardRepository.findAll();
        List<FindResponseBoardListModel> listModels = new ArrayList<>();
        for (Board board : all) {
            listModels.add(new FindResponseBoardListModel(
                    board.getBoardId(),
                    board.getBoardTitle(),
                    board.getBoardText(),
                    board.getBoardInputDt(),
                    board.getBoardUpdateDt()));
        }
        return listModels;
    }

    @Override
    public Page<FindResponseBoardListModel> findAllByQueryDsl(SearchCondition searchCondition, Pageable pageable) {

        return boardQueryRepository.findAllByQueryDsl(searchCondition, pageable);
    }

    @Override
    public FindResponseBoardModel findByBoardId(Long boardId) {
        Board board = em.find(Board.class, boardId);
        FindResponseBoardModel boardModel = new FindResponseBoardModel(
                board.getBoardId(),
                board.getBoardTitle(),
                board.getBoardText(),
                board.getBoardInputDt(),
                board.getBoardUpdateDt());
        return boardModel;
    }

    @Override
    public void save(FindRequestBoardInsertModel boardModel) {
        Board board = Board.builder()
                .boardTitle(boardModel.boardTitle())
                .boardText(boardModel.boardText())
                .boardInputDt(LocalDate.now())
                .build();
        em.persist(board);
        em.close();
    }

    @Override
    public void update(FindRequestBoardUpdateModel boardUpdateModel) {
        Long boardId = boardUpdateModel.boardId();
        Board board = em.find(Board.class, boardId);
        board.setBoardTitle(boardUpdateModel.boardTitle());
        board.setBoardText(boardUpdateModel.boardText());
        em.flush();
    }

    @Override
    public void delete(Long boardId) {
        Board board = em.find(Board.class, boardId);
        em.remove(board);
    }
}
