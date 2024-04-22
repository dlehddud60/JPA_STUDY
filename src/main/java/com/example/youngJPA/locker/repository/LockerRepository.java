package com.example.youngJPA.locker.repository;

import com.example.youngJPA.locker.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker,Long> {
}
