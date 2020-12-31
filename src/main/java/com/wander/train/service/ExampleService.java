package com.wander.train.service;

import com.wander.train.pojo.Example;
import org.springframework.stereotype.Service;

/**
 * example业务层
 *
 * @author admin 2020/12/23/ 20:42
 */
@Service
public interface ExampleService {

    /**
     * 通过id获取
     * @param id
     * @return
     */
    Example getById(int id);
}
