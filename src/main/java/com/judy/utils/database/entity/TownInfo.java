package com.judy.utils.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "town_info")
public class TownInfo {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "level")
    private int level;

    @Column(name = "level1")
    private String level1;

    @Column(name = "level2")
    private String level2;

    @Column(name = "level3")
    private String level3;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

}
