package com.example.youngJPA.locker.service;

import com.example.youngJPA.locker.model.FindResponseLockerListModel;
import com.example.youngJPA.locker.model.FindResponseLockerModel;

import java.util.List;

public interface LockerService {
    void save();

    FindResponseLockerModel findByLockerId(Long lockerId);

    List<FindResponseLockerListModel> findAll();

    void delete(Long lockerId);
}
