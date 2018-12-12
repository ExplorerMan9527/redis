package com.redis.practice;

/**
 * @Auther: Guangjie.Liao
 * @Date: 2018/12/12/012 21:40
 * @Description:
 */
public interface Lock {
    /**
    * @Description: 获取锁
    * @param ${tags}
    * @return ${return_type true 获取成功 false 获取失败}
    * @throws
    * @author Guangjie.Liao
    * @date 2018/12/12/012 21:41
    */
    boolean tryLock(String key ,String value);

    /**
    * @Description: 释放锁
    * @param ${tags}
    * @return ${return_type true 释放成功 false 释放失败}
    * @throws
    * @author Guangjie.Liao
    * @date 2018/12/12/012 21:41
    */
    boolean unLock(String key ,String vaule);
}
