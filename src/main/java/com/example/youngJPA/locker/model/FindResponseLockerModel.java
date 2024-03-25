package com.example.youngJPA.locker.model;

import jakarta.persistence.Column;

public record FindResponseLockerModel(
        Long lockerId,
        String name
) {
}

