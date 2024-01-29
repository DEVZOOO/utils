package com.judy.utils.database.repository;

import com.judy.utils.database.entity.TownInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TownInfoRepository extends JpaRepository<TownInfo, String> {
    List<TownInfo> findAllByLevel(int level);

    /**
     * 지역 조회
     * @param level         검색할 지역 레벨
     * @param parentCode    부모 코드, level = 1이면 null
     */
    @Query(
        nativeQuery = true,
        value = "SELECT" +
            " *" +
            " FROM town_info t" +
            " WHERE t.level = :level" +
            " AND IF(:parentCode IS NULL, 1=1, code LIKE CONCAT(:parentCode, '%'))" +
            " ORDER BY t.level1 ASC, t.level2 ASC, t.level3 ASC"
    )
    List<TownInfo> getTownInfoList(@Param("level") int level, @Param("parentCode") String parentCode);

    /**
     * 지역 상세정보 조회
     */
    TownInfo findTownInfoByCode(String code);

}
