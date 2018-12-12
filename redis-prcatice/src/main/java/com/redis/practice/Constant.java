package com.redis.practice;

/**
 * @Auther: Guangjie.Liao
 * @Date: 2018/12/12/012 21:46
 * @Description:
 */
public class Constant {
    public static final String LOCK_SUCCESS = "SUCCESS";
    public static final String SET_IF_NOT_EXIST = "NX";
    public static final String SET_WITH_EXPIRE_TIME = "PX";
    public static final Integer TIME_OUT = 1000;
    public static final String UNLOCK_LUA;
    public static final String TYELOCK_LUA;


    static {
        StringBuffer unLock = new StringBuffer();
        unLock.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        unLock.append("then ");
        unLock.append("    return redis.call(\"del\",KEYS[1]) ");
        unLock.append("else ");
        unLock.append("    return 0 ");
        unLock.append("end ");
        UNLOCK_LUA = unLock.toString();
    }

    static {
        StringBuffer tryLock = new StringBuffer();
        tryLock.append("if redis.call('setNx',KEYS[1],ARGV[1])");
        tryLock.append("    then if redis.call('get',KEYS[1])==ARGV[1] ");
        tryLock.append("    then");
        tryLock.append("        return redis.call('expire',KEYS[1],ARGV[2])");
        tryLock.append("    else");
        tryLock.append("        return 0 end");
        tryLock.append("end");
        TYELOCK_LUA = tryLock.toString();
    }
}
