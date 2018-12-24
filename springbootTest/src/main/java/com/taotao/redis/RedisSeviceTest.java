package com.taotao.redis;

import java.util.List;
import java.util.Map;


public interface RedisSeviceTest {
	 /**
     * 保存String
     * @param key
     * @param value
     * @return
     */
    public Boolean setString(String key,String value);

    /**
     * 获取String
     * @param key
     * @return
     */
    public String getString(String key);

    /**
     * 保存list
     * @param key
     * @param list
     * @return
     */
    public Boolean setList(String key, List<String> list);

    /**
     * 获取list
     * @param key
     * @return
     */
    public List<String> getList(String key);

    /**
     * 保存map
     * @param key
     * @param map
     * @return
     */
    public Boolean setHashMap(String key, Map<String,String> map);

    /**
     * 获取map
     * @param key
     * @return
     */
    public Map<String,String> getHashMap(String key);

    /**
     * 删除reids缓存
     * @param key
     * @return
     */
    public Boolean removeKey(String key);

}
