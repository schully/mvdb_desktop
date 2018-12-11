/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.mvdb_desktop;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
 *
 * @author ElKebabHenry
 */
public class Utils {
    public static <T> List<T> map(T[] src, MapCallback<T> cb) {
        return map(Arrays.asList(src),cb);
    }
    public static <T> List<T> map(List<T> src, MapCallback<T> cb) {
        ArrayList<T> mapd = new ArrayList<>();
        
        for (T item : src){
            mapd.add(item);
        }
        
        return mapd;
    }
    
    public static <T> String join(T[] arr) {
        return join(Arrays.asList(arr));
    }
    
    public static <T> String join(List<T> arr) {
        String sep = ", ";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i <= (arr.size()-1); i++) {
            sb.append(arr.get(i).toString());
            if (i < arr.size()-1){
                sb.append(sep);
            }
        }
        return sb.toString();
    }
    
    public static List<String> splitTrim(String str, String sep){
        return map(str.split(sep), new MapCallback<String>(){
            @Override
            public String map(String orig) {
                return orig.trim();
            }
            
        });
    }
    
    public static Map<String, Object> getMapFromJson(JSONObject obj) {
        Map<String, Object> out = new HashMap<>();
        Iterator<Entry<String, Object>> itr = obj.entrySet().iterator();
        while (itr.hasNext()) {            
            Entry<String, Object> nxt = itr.next();
            out.put(nxt.getKey(), nxt.getValue());
        }
        return out;
    }
    
    public static String empty(String orig){
        if(orig == null){
            return "";
        }
        return orig;
    }
    
}
