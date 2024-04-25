package com.example.youngJPA.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "BOARD")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
public class Board {

    @Column(name = "BOARD_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(name = "BOARD_TITLE", nullable = false)
    private String boardTitle;

    @Column(name = "BOARD_TEXT", nullable = false, length = 4000)
    private String boardText;

    @Column(name = "BOARD_INPUT_DT", updatable = false)
    private LocalDate boardInputDt;

    @Column(name = "BOARD_UPDATE_DT", insertable = false)
    private LocalDate boardUpdateDt;


}
