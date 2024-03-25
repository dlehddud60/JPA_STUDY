package com.example.youngJPA.locker.repository;

import com.example.youngJPA.locker.domain.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker,Long> {
}
