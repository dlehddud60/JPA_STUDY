package com.example.youngJPA.board.service.impl;

import com.example.youngJPA.board.entity.Board;
import com.example.youngJPA.board.repository.BoardRepository;
import com.example.youngJPA.board.service.BoardService;
import com.example.youngJPA.member.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final EntityManager em;
    @Override
    public void save(Board board) {
        log.info("board엔티티 영속화 persist");
        em.persist(board);
        log.info("board엔티티 준영속");
//        em.detach(board);
//        em.clear();
//        log.info("board엔티티 재영속");
//        em.merge(board);
        log.info("text수정과 수정자 작업");
        board.setBoardText("공지사항 수정입니다.");
        board.setBoardModerDt(LocalDate.now());
        board.setBoardModerName("홍길동");
        log.info("영속성 컨텍스트에서 DB로 flush작업 쓰기지연 저장소에 모와진 쿼리문 날리기");

    }

    @Override
    public Board findByBoardId(Long boardSeq) {
        log.info("1차 캐쉬에서 board 엔티티 조회");
        Board board1 = em.find(Board.class,boardSeq);
        Board board2 = em.find(Board.class,boardSeq);
        log.info("================boardEntity1================={}",board1);
        log.info("================boardEntity2================={}",board2);
        log.info("==================entity동일성 비교=========================={}",board1 == board2);
      return  boardRepository.findById(boardSeq).get();
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public void delete(Long boardSeq) {
        boardRepository.deleteById(boardSeq);
    }
}

