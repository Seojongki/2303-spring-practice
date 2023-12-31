package com.tj.edu.practice5.jpa.model;

import com.tj.edu.practice5.jpa.repository.MemberLogHistoryRepository;
import com.tj.edu.practice5.jpa.util.SpringBeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

public class MemberEntityListener {

    @PostPersist
    @PostUpdate
    public void afterMemberSave(Object o){

        MemberLogHistoryRepository memberLogHistoryRepository = SpringBeanUtils.getBean(MemberLogHistoryRepository.class);

        Member member = (Member) o;

        MemberLogHistory memberLogHistory = MemberLogHistory.builder()
//                .memberId(member.getId())
                .member(member)
                .name(member.getName())
                .email(member.getEmail())
                .build();

        memberLogHistoryRepository.save(memberLogHistory);
    }
}
