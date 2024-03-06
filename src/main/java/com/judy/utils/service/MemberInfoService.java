package com.judy.utils.service;

import com.judy.utils.database.entity.MemberInfo;
import com.judy.utils.database.repository.MemberInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberInfoService {
    MemberInfoRepository memberInfoRepository;

    @Autowired
    public MemberInfoService(MemberInfoRepository memberInfoRepository) {
        this.memberInfoRepository = memberInfoRepository;
    }

    public List<MemberInfo> findAll() {
        return memberInfoRepository.findAll();
    }
}
