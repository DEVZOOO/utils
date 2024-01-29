package com.judy.utils.service;

import com.judy.utils.database.entity.TownInfo;
import com.judy.utils.database.repository.TownInfoRepository;
import com.judy.utils.exception.UtilsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TownInfoService {
    
    TownInfoRepository townInfoRepository;
    
    @Autowired
    public TownInfoService(TownInfoRepository townInfoRepository) {
        this.townInfoRepository = townInfoRepository;
    }

    /**
     * 지역 조회
     */
    public List<TownInfo> getTownInfoList(int level, String parentCode) {
        // level 범위 넘어간 경우
        if (level < 1 || level > 3) {
            // exception
            throw new UtilsException(level + " is out of range: 1~3");
        }

        // level이 2, 3인데 parentCode 없는 경우
        if (level > 1 && StringUtils.isEmpty(parentCode)) {
            throw new UtilsException("level " + level + " need parentCode.");
        }

        return townInfoRepository.getTownInfoList(level, parentCode);
    }

    /**
     * 특정 다중 지역 상세정보 조회
     */
    public List<TownInfo> getTownInfoDetailList(List<String> codeList) {
        return townInfoRepository.findAllByCodeInOrderByLevel1AscLevel2AscLevel3Asc(codeList);
    }

    /**
     * 지역 상세정보 조회
     */
    public TownInfo getTownInfoDetail(String code) {
        return townInfoRepository.findTownInfoByCode(code);
    }
}
