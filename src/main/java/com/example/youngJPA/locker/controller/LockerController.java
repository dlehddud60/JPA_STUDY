package com.example.youngJPA.locker.controller;

import com.example.youngJPA.locker.model.FindResponseLockerListModel;
import com.example.youngJPA.locker.model.FindResponseLockerModel;
import com.example.youngJPA.locker.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("locker")
@RequiredArgsConstructor
public class LockerController {
    private final LockerService lockerService;

    @GetMapping("/save")
    public void save() {
        lockerService.save();
    }

    @GetMapping("/find/{lockerId}")
    public FindResponseLockerModel findByLocker(@PathVariable(name = "lockerId") Long lockerId) {
        return lockerService.findByLockerId(lockerId);
    }

    @GetMapping
    public List<FindResponseLockerListModel> findAll() {
        return lockerService.findAll();
    }

    @GetMapping("delete/{lockerId}")
    public void delete(@PathVariable(name = "lockerId") Long lockerId) {
        lockerService.delete(lockerId);
    }
}
