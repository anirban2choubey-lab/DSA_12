package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValuePair_891 {
    public static void main(String[] args) {

    }

    public class TimeMap {
        Map<String, List<EntryData>> entry;

        public TimeMap() {
            entry = new HashMap<>();
        }

        public class EntryData {
            String val;
            int timeStamp;

            public EntryData(String val, int timeStamp) {
                this.val = val;
                this.timeStamp = timeStamp;
            }
        }

        public void set(String key, String value, int timestamp) {
            entry.computeIfAbsent(key, k -> new ArrayList<>()).add(new EntryData(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!entry.containsKey(key))
                return "";
            List<EntryData> entries = entry.get(key);
            int low = 0, high = entries.size() - 1;
            String ans = "";
            while (low <= high) {
                int mid = (low + high) / 2;
                int midEntry = entries.get(mid).timeStamp;
                if (midEntry == timestamp)
                    return entries.get(mid).val;
                if (midEntry < timestamp) {
                    ans = entries.get(mid).val;
                    low = mid + 1;
                } else
                    high = mid - 1;

            }
            return ans;
        }
    }

}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

