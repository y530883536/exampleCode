package com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/set/{key}/{value}")
    public String set(@PathVariable String key,@PathVariable String value){
        redisTemplate.opsForValue().set(key,value);
        return "set ok";
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key){
        String value = redisTemplate.opsForValue().get(key);
        System.out.println(value.equals("estone"));
        System.out.println(value);
        return value;
    }

    @GetMapping("/hset/{name}/{key}/{value}")
    public String hset(@PathVariable String name,@PathVariable String key,@PathVariable String value){
        redisTemplate.opsForHash().put(name,key,value);
        return "hset ok";
    }

    @GetMapping("/hget/{name}/{key}")
    public Object hget(@PathVariable String name,@PathVariable String key){
        Object object = redisTemplate.opsForHash().get(name, key);
        return object;
    }
}
