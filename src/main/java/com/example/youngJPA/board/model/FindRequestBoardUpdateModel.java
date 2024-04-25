package com.example.youngJPA.board.model;

public record FindRequestBoardUpdateModel(
        Long boardId,
        String boardTitle,
        String boardText
) {
}
