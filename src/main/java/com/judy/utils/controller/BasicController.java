package com.judy.utils.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class BasicController {

    /**
     * ping pong
     */
    @GetMapping("/ping")
    public ResponseEntity<String> pingpong() {
        return ResponseEntity.ok("pong");
    }

    /**
     * Main
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 엑셀 업로드 화면
     */
    @GetMapping("/excelUpload")
    public String excelUpload() {
        return "excel_upload";
    }

}
