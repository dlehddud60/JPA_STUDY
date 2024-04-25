package com.example.youngJPA.board.model;

import java.time.LocalDate;

public record FindResponseBoardModel(
        Long boardId,
        String boardTitle,
        String boardText,
        LocalDate boardInputDt,
        LocalDate boardUpdateDt
) {
}
