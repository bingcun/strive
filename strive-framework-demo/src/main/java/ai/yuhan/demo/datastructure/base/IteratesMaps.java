package ai.yuhan.demo.datastructure.base;

import jdk.internal.org.objectweb.asm.Handle;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/15 15:10
 * @Version 1.0
 */
public class IteratesMaps {

    private Map initMaps() {
        Map<String, String> maps = new HashMap<>();
        maps.put("1", "1");
        maps.put("2", "2");
        maps.put("3", "3");
        return maps;
    }

    /**
     * 方法一：普通的foreach循环，使用keySet()方法，遍历key(带泛型结构的)
     */
    @Test
    public void test01() {
        Map<String,String> maps = initMaps();
        for(String ss:maps.keySet()){
            System.out.println("keys:" + ss +",value:" + maps.get(ss));
        }
    }

    /**
     * 方法二：把所有的键值对装入迭代器中，然后遍历迭代器
     */
    @Test
    public void test02() {
        Map<String,String> maps = initMaps();
        Iterator<Map.Entry<String,String>> iterator = maps.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String>  entry = iterator.next();
            System.out.println("key:" + entry.getKey()+ ",value:" +entry.getValue());
        }
    }

    /**
     * 方法三：分别得到key和value
     */
    @Test
    public void test03(){
        Map<String,String> maps = initMaps();
        //分别得到Key
        for(String obj:maps.keySet()){
            System.out.println("key:" + obj);
        }

        //分别得到value
        for(String obj1:maps.values()){
            System.out.println("value:" + obj1);
        }
    }

    /**
     * 方法四：entrySet()方法
     */
    @Test
    public void test04(){
        Map<String,String> maps = initMaps();
        Set<Map.Entry<String,String>> entrySets = maps.entrySet();
        for(Map.Entry entry:entrySets){
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }
    }

    /**
     * jdk8 遍历的几种方式
     */
    @Test
    public void test05(){
        Map<String,String> maps = initMaps();

        maps.forEach((key,value)->{
            System.out.println("key:"+key+",value:"+value);
        });

        maps.keySet().stream().forEach(key->{
            System.out.println("key:"+key+",value:"+maps.get(key));
        });

        maps.entrySet().stream().parallel().forEach(key->{
            System.out.println("key:"+key+",value:"+maps.get(key));
        });

        Iterator<Map.Entry<String,String>> iterator = maps.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }
}
