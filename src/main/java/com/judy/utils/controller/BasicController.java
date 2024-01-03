package com.judy.utils.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class BasicController {

    /**
     * Main
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
