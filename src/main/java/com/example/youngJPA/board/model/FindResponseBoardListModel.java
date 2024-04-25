package com.example.youngJPA.board.model;

import java.time.LocalDate;

public record FindResponseBoardListModel(
        Long boardId,
        String boardTitle,
        String boardText,
        LocalDate boardInputDt,
        LocalDate boardUpdateDt
) {
}
