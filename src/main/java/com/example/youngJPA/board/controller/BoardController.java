package com.example.youngJPA.board.controller;

import com.example.youngJPA.board.model.FindRequestBoardInsertModel;
import com.example.youngJPA.board.model.FindRequestBoardUpdateModel;
import com.example.youngJPA.board.model.SearchCondition;
import com.example.youngJPA.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(Model model, @ModelAttribute(name = "searchValue") SearchCondition searchCondition, @PageableDefault(page = 0, size = 10) Pageable pageable) {

        model.addAttribute("list", boardService.findAllByQueryDsl(searchCondition, pageable));
        model.addAttribute("maxPage", 10);
        model.addAttribute("searchValue", searchCondition.searchValue());
    }

    @GetMapping("/find/{boardId}")
    public String view(@PathVariable(name = "boardId") Long boardId, Model model) {
        model.addAttribute("info", boardService.findByBoardId(boardId));
        return "/board/view";
    }

    @GetMapping("/write")
    public void write() {
    }

    @PostMapping("/write")
    public String save(@ModelAttribute FindRequestBoardInsertModel boardModel) {
        boardService.save(boardModel);
        return "redirect:/board/list";
    }

    @GetMapping("/update/{boardId}")
    public String updateWrite(Model model, @PathVariable(name = "boardId") Long boardId) {
        model.addAttribute("info", boardService.findByBoardId(boardId));
        return "/board/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute FindRequestBoardUpdateModel boardUpdateModel) {
        boardService.update(boardUpdateModel);
        return "redirect:/board/find/" + boardUpdateModel.boardId();
    }

    @GetMapping("/delete/{boardId}")
    public String delete(@PathVariable(name = "boardId") Long boardId) {
        boardService.delete(boardId);
        return "redirect:/board/list";
    }
}
