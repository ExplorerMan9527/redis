package com.redis.practice.redlock;

import com.redis.practice.Lock;

/**
 * @Auther: Guangjie.Liao
 * @Date: 2018/12/12/012 21:43
 * @Description: redLock 算法实现redis 分布式锁
 */
public class RedisRedLock implements Lock {

    @Override
    public boolean tryLock(String key ,String value) {


        return false;
    }

    @Override
    public boolean unLock(String key ,String vaule) {
        return false;
    }
}
