package com.example.youngJPA.team.repository;

import com.example.youngJPA.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
