package com.judy.utils.database.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "member_info")
public class MemberInfo {

    @Id
    @Column(name = "hp_ci", unique = true)
    @Schema(description = "휴대폰 본인인증 CI, PK", required = true)
    private String hpCi;

    //    @Id
    @Column(name = "mb_id")
    @Schema(description = "회원 아이디")
    private String mbId;

    @Column(name = "mb_pwd")
    @Schema(description = "비밀번호", required = true)
    private String mbPwd;

    @Column(name = "mb_hp")
    @Schema(description = "휴대폰 번호, - 없이", required = true, example = "01012345678")
    private String mbHp;

    @Column(name = "mb_name")
    @Schema(description = "이름", required = true)
    private String name;

}
