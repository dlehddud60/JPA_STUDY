package com.example.youngJPA.team.model;

import jakarta.persistence.Column;

public record FindResponseTeamModel(
        Long teamId,
        String name
) {

}
