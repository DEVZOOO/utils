package com.judy.utils.controller;

import com.judy.utils.database.entity.MemberInfo;
import com.judy.utils.database.entity.TownInfo;
import com.judy.utils.dto.CommonRes;
import com.judy.utils.service.MemberInfoService;
import com.judy.utils.service.TownInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/town/*")
@Tag(name = "지역 정보 관련 REST API")
public class TownInfoController {

//    TownInfoService townInfoService;
    MemberInfoService memberInfoService;

    @Autowired
    public TownInfoController(
//        TownInfoService townInfoService,
        MemberInfoService memberInfoService
    ) {
//        this.townInfoService = townInfoService;
        this.memberInfoService = memberInfoService;
    }
    
/*
    @Operation(summary = "지역 리스트 조회")
    @GetMapping(value = "list", headers = {"Accept=application/json;charset=UTF-8"})
    public ResponseEntity<CommonRes<List<TownInfo>>> list(
        @Parameter(description = "지역 레벨") @RequestParam int level,
        @Parameter(description = "부모 지역 코드, level = 1 인 경우 null") @RequestParam(required = false) String parentCode
    ) {
        List<TownInfo> list = townInfoService.getTownInfoList(level, parentCode);
        return ResponseEntity.ok(new CommonRes<>(list));
    }

    @Operation(summary = "특정 다중 지역 상세정보 조회")
    @GetMapping(value = "detail", headers = {"Accept=application/json;charset=UTF-8"})
    public ResponseEntity<CommonRes<List<TownInfo>>> detailList(@RequestParam List<String> codeList) {
        List<TownInfo> list = townInfoService.getTownInfoDetailList(codeList);
        return ResponseEntity.ok(new CommonRes<>(list));
    }

    @Operation(summary = "지역 상세정보 조회")
    @GetMapping(value = "{code}", headers = {"Accept=application/json;charset=UTF-8"})
    public ResponseEntity<CommonRes<TownInfo>> detail(@PathVariable String code) {
        TownInfo info = townInfoService.getTownInfoDetail(code);
        return ResponseEntity.ok(new CommonRes<>(info));
    }
 */


    @Operation(summary = "TEST(MemberInfo)")
    @GetMapping(value = "members", headers = {"Accept=application/json;charset=UTF-8"})
    public ResponseEntity<CommonRes<List<MemberInfo>>> members() {
        List<MemberInfo> list = memberInfoService.findAll();
        return ResponseEntity.ok(new CommonRes<>(list));
    }


}
