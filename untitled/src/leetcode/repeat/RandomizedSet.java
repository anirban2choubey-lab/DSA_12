package leetcode.repeat;

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    ;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;


        list.add( val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int lastElement = list.getLast();
        int index = map.get(val);
        list.set(index, lastElement);
        list.removeLast();
        map.put(lastElement, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {

        return list.get(random.nextInt(list.size()));
    }
}