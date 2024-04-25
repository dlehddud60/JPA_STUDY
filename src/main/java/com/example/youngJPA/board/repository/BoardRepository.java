package com.example.youngJPA.board.repository;

import com.example.youngJPA.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
