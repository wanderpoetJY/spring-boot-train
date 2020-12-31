package com.wander.train.service.impl;

import com.wander.train.mapper.ExampleMapper;
import com.wander.train.pojo.Example;
import com.wander.train.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 实现类
 *
 * @author admin 2020/12/23/ 20:43
 */
@Component
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleMapper exampleMapper;

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    RedisTemplate redisTemplate;


    /**
     * 缓存基本使用
     * (1)@Cacheable：会在方法执行前查询缓存，缓存中有，则不执行方法。
     *      cacheName/value:指定缓存组件的名字
     *      key：指定键，默认为方法传入的值
     *      keyGenerator：key的生成规则，与key二选一使用
     *
     * (2)@CachePut:会先执行方法，然后将执行结果在缓存中进行更新
     * (3)@CacheEvict：缓存清除
     * @param id
     * @return
     */
    @Cacheable(value = "emp", key = "#id")
    @Override
    public Example getById(int id) {
        System.out.println("方法执行了");
        return exampleMapper.getById(id);
    }
}
