package com.example.youngJPA.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "BOARD")
@SequenceGenerator(
        name = "BOARD_SEQ_GNE",
        sequenceName = "BOARD_SEQ",
        initialValue = 1000000,
        allocationSize = 1
)
public class Board {

    @Column(name = "BOARD_SEQ", length = 20,nullable = false ,updatable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BOARD_SEQ_GNE")
    private Long boardSeq;

    @Column(name = "BOARD_TITLE", length = 300,nullable = false)
    private String boardTitle;

    @Column(name = "BOARD_TEXT",length = 3000, nullable = false)
    private String boardText;

    @Column(name = "BOARD_INPUT_NAME" , length = 300, nullable = false,updatable = false)
    private String boardInputName;

    @Column(name = "BOARD_INPUT_DT", nullable = false , updatable = false)
    private LocalDate boardInputDt;

    @Column(name = "BOARD_MODER_NAME", insertable = false)
    private String  boardModerName;

    @Column(name = "BOARD_MODER_DT", insertable = false)
    private LocalDate boardModerDt;

    @Enumerated(EnumType.STRING)
    @Column(name = "BOARD_AUTH")
    private Auth auth;

}

