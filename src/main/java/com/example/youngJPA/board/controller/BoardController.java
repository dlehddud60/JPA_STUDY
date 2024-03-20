package com.example.youngJPA.board.controller;

import com.example.youngJPA.board.entity.Auth;
import com.example.youngJPA.board.entity.Board;
import com.example.youngJPA.board.service.BoardService;
import com.example.youngJPA.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/save")
    public void save() {
        log.info("board엔티티 비영속");
        Board board = Board.builder()
                .boardTitle("공지사항1")
                .boardText("안녕하세요 반갑습니다.")
                .boardInputDt(LocalDate.now())
                .boardInputName("이동영")
                .auth(Auth.MASTER)
                .build();
        boardService.save(board);
    }

    @GetMapping("/find/{boardSeq}")
    public Board find(@PathVariable(name = "boardSeq") Long boardSeq) {
        return boardService.findByBoardId(boardSeq);
    }

    @GetMapping
    public List<Board> findAll() {
        return  boardService.findAll();
    }

    @GetMapping("/delete/{boardSeq}")
    public void delete(@PathVariable(name = "boardSeq") Long boardSeq) {
        boardService.delete(boardSeq);
    }
}
