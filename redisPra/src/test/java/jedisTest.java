import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mr.wxx
 * @create 2021-04-22-13:31
 **/
public class jedisTest {

    @Test
    public void testKey(){
        Jedis jedis = new Jedis("192.168.112.130", 6379);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(jedis.ttl("hhl1"));
        Boolean hhl1 = jedis.exists("hhl1");
        System.out.println(hhl1);
    }

    @Test
    public void StringTest(){
        Jedis jedis = new Jedis("192.168.112.130", 6379);
        jedis.append("a", "222");
        System.out.println(jedis.get("a"));
    }

    @Test
    public void HashMapTest(){
        Jedis jedis = new Jedis("192.168.112.130", 6379);

        Map<String,String> addMap = new HashMap<String, String>();
        addMap.put("addr", "huangshi");
        addMap.put("bachelor", "master");
        jedis.hset("hmap1", addMap);
        Map<String, String> hmap1 = jedis.hgetAll("hmap1");
        for (Map.Entry<String, String> entry : hmap1.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
//        jedis.hset();
    }

    @Test
    public void ZsetTest(){
        Jedis jedis = new Jedis("192.168.112.130", 6379);
        Set<Tuple> zset1 = jedis.zrangeByScoreWithScores("zset1", 10, 50);
        for (Tuple tuple : zset1) {
            System.out.println(tuple.toString());
        }
        Set<Tuple> zset11 = jedis.zrangeWithScores("zset1", 10, 50);
        for (Tuple tuple : zset1) {
            System.out.println(tuple.toString());
        }
    }
}
