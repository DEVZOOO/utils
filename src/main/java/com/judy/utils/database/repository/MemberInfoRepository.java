package com.judy.utils.database.repository;

import com.judy.utils.database.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, String> {

}
