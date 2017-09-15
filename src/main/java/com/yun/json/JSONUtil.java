package com.yun.json;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caiyunwu on 2017/6/12.
 */
public class JSONUtil {
    public static void main(String[] args) {
        Map<String, Object> log = new HashedMap();
        //string value
        log.put("k1","v1");
        log.put("k2","v2");
        log.put("k3","v3");

        //map value
        Map<String, Object> subLogMap = new HashedMap();
        subLogMap.put("k4.1", "v4.1");
        subLogMap.put("k4.2", "v4.2");
        subLogMap.put("k4.3", "v4.3");
        log.put("k4", subLogMap);

        //array value
        List<Object> sublogArr =new ArrayList();
        sublogArr.add("v5.1");
        sublogArr.add("v5.2");
        sublogArr.add("v5.3");
        log.put("k5", sublogArr);

        //array map vavlue
        List<Object> subLogArrMap = new ArrayList();
        Map<String,Object> map1=new HashMap<String,Object>();
        map1.put("k6.1.1","v6.1.1");
        map1.put("k6.1.2","v6.1.2");
        Map<String,Object> map2=new HashMap<String,Object>();
        map2.put("k6.2.1","v6.2.1");
        map2.put("k6.2.2","v6.2.2");
        subLogArrMap.add(map1);
        subLogArrMap.add(map2);
        log.put("k6", subLogArrMap);

        String json = JSON.toJSONString(log);
        System.out.println(json);

    }
}
