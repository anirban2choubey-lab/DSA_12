package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValuePair_891_treeMap {
    public class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key))
                return "";
            String ans = "";
            TreeMap<Integer, String> tm = map.get(key);
            Integer floorkey =  tm.floorKey(timestamp);
            if (floorkey==null)
                return "";
            return tm.get(floorkey);
        }
    }
}
