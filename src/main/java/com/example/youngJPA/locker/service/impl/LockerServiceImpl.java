package com.example.youngJPA.locker.service.impl;

import com.example.youngJPA.locker.domain.Locker;
import com.example.youngJPA.locker.model.FindResponseLockerListModel;
import com.example.youngJPA.locker.model.FindResponseLockerModel;
import com.example.youngJPA.locker.repository.LockerRepository;
import com.example.youngJPA.locker.service.LockerService;
import com.example.youngJPA.member.entity.Member;
import com.example.youngJPA.member.model.FindResponseMemberWithLockerListModel;
import com.example.youngJPA.member.model.FindResponseMemberWithLockerModel;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LockerServiceImpl implements LockerService {
    private final LockerRepository lockerRepository;
    private final EntityManager em;


    @Override
    public void save() {
        Locker locker = Locker.builder()
                .name("개인라커")
                .build();
        em.persist(locker);
    }

    @Override
    public FindResponseLockerModel findByLockerId(Long lockerId) {

        Locker locker = em.find(Locker.class, lockerId);
        Member member = locker.getMember();
        FindResponseMemberWithLockerModel findResponseMemberWithLockerModel = new FindResponseMemberWithLockerModel(member.getMemberId(),member.getId(), member.getPw());
        FindResponseLockerModel lockerModel = new FindResponseLockerModel(locker.getLockerId(),locker.getName(),findResponseMemberWithLockerModel);
        return lockerModel;
    }

    @Override
    public List<FindResponseLockerListModel> findAll() {
        List<Locker> list = lockerRepository.findAll();
        List<FindResponseLockerListModel> findResponseLockerListModels = new ArrayList<>();
        for (Locker locker : list) {
            Member member = locker.getMember();
            FindResponseMemberWithLockerListModel findResponseMemberWithLockerListModel = new FindResponseMemberWithLockerListModel(member.getMemberId(), member.getId(), member.getPw());
            findResponseLockerListModels.add(new FindResponseLockerListModel(locker.getLockerId(),locker.getName(),findResponseMemberWithLockerListModel));
        }
        return findResponseLockerListModels;
    }

    @Override
    public void delete(Long lockerId) {
        em.remove(em.find(Locker.class, lockerId));
    }
}
