package com.example.youngJPA.board.service;

import com.example.youngJPA.board.entity.Board;
import com.example.youngJPA.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    void save(Board board);

    Board findByBoardId(Long boardSeq);

    List<Board> findAll();

    void delete(Long boardSeq);
}
