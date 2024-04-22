package com.example.youngJPA.team.repository;

import com.example.youngJPA.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
