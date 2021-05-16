package com.redisPra;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author Mr.wxx
 * @create 2021-04-22-10:54
 **/
public class MesgPra {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.112.130", 6379);
        checkTime(jedis,"15235152403");
    }

    //检查用户输入的验证码与当前redis中保存的验证码
    private void checkCode(Jedis jedis, String phone, String code){
        //验证码的对应的手机key
        String codeKey = "Msg"+phone + "code";
        String codeGet = jedis.get(codeKey);
        if(codeGet.equals(code)){
            System.out.println("验证码正确！");
        }else{
            System.out.println("验证码错误！");
        }
    }

    //将验证码存入redis中，key为手机号拼接的key
    //以及手机号对应的发送次数key，值为验证码发送次数
    private static void checkTime(Jedis jedis, String phone){
        //生成验证码
        String code = randCode();
        //验证码的对应的手机key
        String codeKey = "Msg"+phone + "code";
        //验证码发送次数的手机key
        String timeKey = "Msg" + phone + "time";
        // 检查发送次数
        String count = jedis.get(timeKey);
        if(count == null){
            //一次都没有发送
            jedis.set(timeKey, "1");
            // 设置验证码的过期时间为120秒
            jedis.setex(codeKey, 120, code);
            System.out.println("验证码发送成功！");
        }else if(Integer.parseInt(count) <= 2){
            //如果发送次数小于3次，则可以发送
            jedis.incr(timeKey);
            jedis.setex(codeKey, 120, code);
            System.out.println("验证码发送成功！");
        }else{
            //次数超过3次，不能发送
            System.out.println("验证码发送次数超过3次！");
        }
    }

    // 生成验证码
    private static String randCode(){
        //通过Random类
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; ++i){
            // bound参数为生成 0- bound的值
            int tmp = random.nextInt(10);
            sb.append(tmp);
        }
        return sb.toString();
    }


}
