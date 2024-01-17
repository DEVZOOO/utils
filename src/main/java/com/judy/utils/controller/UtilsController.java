package com.judy.utils.controller;

import com.judy.utils.dto.CommonRes;
import com.judy.utils.service.UtilsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/utils/*")
public class UtilsController {

    UtilsService utilsService;

    @Autowired
    public UtilsController(UtilsService utilsService) {
        this.utilsService = utilsService;
    }

    /**
     * Excel to List
     */
    @PostMapping("excel")
    @ResponseBody
    public ResponseEntity<CommonRes<Map<String, Object>>> convertExcel(MultipartHttpServletRequest mreq) {
        CommonRes<Map<String, Object>> result;
        try {
            Map<String, Object> map = utilsService.convertExcel(mreq.getFile("file"));
            result = new CommonRes<>(map, "0", "변환 성공");
        } catch (Exception e) {
            e.printStackTrace();
            result = new CommonRes<>();
            result.setResCode("-1");
            result.setResMsg(e.getMessage());
        }

        return ResponseEntity.ok(result);
    }


}
