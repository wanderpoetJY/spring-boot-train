package com.wander.train.controller;

import com.wander.train.pojo.Example;
import com.wander.train.service.impl.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * controller测试
 *
 * @author admin 2020/12/23/ 13:49
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    ExampleServiceImpl exampleService;


    @ResponseBody
    @GetMapping("/{id}")
    public Example hello(@PathVariable("id") int id){
        return exampleService.getById(id);
    }

}
