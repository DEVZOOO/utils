package com.judy.utils.database.repository;

import com.judy.utils.database.entity.TownInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TownInfoRepository extends JpaRepository<TownInfo, String> {
    List<TownInfo> findAllByLevel(int level);
}
