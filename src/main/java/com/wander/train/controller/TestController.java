package com.wander.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author admin 2020/12/28/ 14:39
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @GetMapping("/first")
    public String test01(){
        return "test";
    }

    @GetMapping("/secone")
    public String test02(){
        return "test";
    }
}
