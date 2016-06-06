package redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		//���ӱ���Redis����
		 Jedis jedis = new Jedis("localhost");
		 //��������
		 setStringTest(jedis);
		 
		 //����String
//		 jedis.set("password", "89");
//		 jedis.del("password");
		 
		 //���û�ȡredis String����
		 getStringTest(jedis);
		 
		 //���û�ȡredis List����
//		 getListTest(jedis);
		 
		 //���û�ȡredis ����String����
		// getStringAllTest(jedis);
		 
	}
	
	public static void setStringTest(Jedis jedis){
		jedis.set("name", "����");
		jedis.set("age","25");
	}
	
	
	/**
	 * ����: ��ȡRedis String .
	 * @author lilihao
	 * @date 2016��5��1��
	 */
	public  static void getStringTest(Jedis jedis){
		//�ж�redis�Ƿ�����
	   System.out.println("�Ƿ���: "+jedis.ping());
	   //��ȡString�ַ���
	   System.out.println("name:"+jedis.get("name"));
	   System.out.println("age:"+jedis.get("age"));
//	   System.out.println("user:"+jedis.get("user"));
	   System.out.println("myKey:"+jedis.get("myKey"));
	   System.out.println("password:"+jedis.get("password"));
//	   System.out.println("user:"+jedis.get("user:1"));
	}
	
	/**
	 * 
	 * ����: ��ȡRedis List
	 * @author lilihao
	 * @date 2016��5��1�� 
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
	 * ����: ��ȡRedis ����key
	 * @author lilihao
	 * @date 2016��5��1�� 
	 * @param jedis
	 */
	public static void getStringAllTest(Jedis jedis){
		Set<String> set= jedis.keys("*");
		for (String string : set) {
			System.out.println(string);
		}
	}
}
