package com.taotao.redis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;




@Component
public class RedisServiceImpl implements RedisSeviceTest {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public Boolean setString(String key, String value) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set(key,value);;
		return true;
	}

	@Override
	public String getString(String key) {
		// TODO Auto-generated method stub
		String value = (String) redisTemplate.opsForValue().get(key);
		return value;
	}

	@Override
	public Boolean setList(String key, List<String> list) {
		// TODO Auto-generated method stub
		for(int i =0;i<list.size();i++){
		  redisTemplate.opsForList().rightPush(key,list.get(i));
		}
		return true;
	}

	@Override
	public List<String> getList(String key) {
		// TODO Auto-generated method stub
		List<String> lsit = redisTemplate.opsForList().range(key,0,-1);
		return lsit;
	}

	public Boolean setHashMap(String key, Map<String, String> map) {
		// TODO Auto-generated method stubm
		redisTemplate.opsForHash().putAll(key,map);
		return true;
	}

	public Map<String, String> getHashMap(String key) {
		// TODO Auto-generated method stub
		//redisTemplate.opsForHash().entries(key);
        HashOperations<String,String,String> hashOperations =  redisTemplate.opsForHash();
		return hashOperations.entries(key);
	}

	@Override
	public Boolean removeKey(String key) {
		// TODO Auto-generated method stub
		redisTemplate.delete(key);
		return true;
	}

}
