package redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		//连接本地Redis服务
		 Jedis jedis = new Jedis("localhost");
		 //设置数据
		 setStringTest(jedis);
		 
		 //存入String
//		 jedis.set("password", "89");
//		 jedis.del("password");
		 
		 //调用获取redis String方法
		 getStringTest(jedis);
		 
		 //调用获取redis List方法
//		 getListTest(jedis);
		 
		 //调用获取redis 所有String方法
		// getStringAllTest(jedis);
		 
	}
	
	public static void setStringTest(Jedis jedis){
		jedis.set("name", "王五");
		jedis.set("age","25");
	}
	
	
	/**
	 * 描述: 获取Redis String .
	 * @author lilihao
	 * @date 2016年5月1日
	 */
	public  static void getStringTest(Jedis jedis){
		//判断redis是否运行
	   System.out.println("是否开启: "+jedis.ping());
	   //获取String字符串
	   System.out.println("name:"+jedis.get("name"));
	   System.out.println("age:"+jedis.get("age"));
//	   System.out.println("user:"+jedis.get("user"));
	   System.out.println("myKey:"+jedis.get("myKey"));
	   System.out.println("password:"+jedis.get("password"));
//	   System.out.println("user:"+jedis.get("user:1"));
	}
	
	/**
	 * 
	 * 描述: 获取Redis List
	 * @author lilihao
	 * @date 2016年5月1日 
	 * @param jedis
	 */
	public static void getListTest(Jedis jedis){
		 List<String> list= jedis.lrange("user",0,10);
		 for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 
	 * 描述: 获取Redis 所有key
	 * @author lilihao
	 * @date 2016年5月1日 
	 * @param jedis
	 */
	public static void getStringAllTest(Jedis jedis){
		Set<String> set= jedis.keys("*");
		for (String string : set) {
			System.out.println(string);
		}
	}
}
