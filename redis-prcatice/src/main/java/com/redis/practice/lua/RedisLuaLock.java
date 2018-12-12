package com.redis.practice.lua;

import com.redis.practice.Constant;
import com.redis.practice.Lock;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @Auther: Guangjie.Liao
 * @Date: 2018/12/12/012 21:40
 * @Description:  setNX +  lua 脚本 算法实现redis 分布式锁
 */
@Component
public class RedisLuaLock  implements Lock {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean tryLock(String key ,String value) {
        try{
            RedisScript<String> redisScript = new DefaultRedisScript<>(Constant.TYELOCK_LUA, String.class);
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(key),value,Constant.TIME_OUT);
            if(Constant.LOCK_SUCCESS.equals(result)){
                return true;
            }
        }catch(Exception e){

        }
        return false;
    }

    @Override
    public boolean unLock(String key ,String vaule) {
        RedisScript<String> redisScript = new DefaultRedisScript<>(Constant.UNLOCK_LUA, String.class);
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(key),vaule);
        if(Constant.LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
