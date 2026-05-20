package leetcode.repeat;

import java.util.HashMap;
import java.util.Map;

public class LRU_cache {
    public class Node_lru {
        int val;
        Node_lru next;
        Node_lru prev;

        Node_lru(int val) {
            this.val = val;
        }
    }

    Node_lru head = null;
    Node_lru tail = null;
    final Map<Integer, Integer> map;
    final int capacity;

    LRU_cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    private void insert(Node_lru node) {
        Node_lru nxt = head.next;
        head.next = node;
        node.prev = head;
        node.next = nxt;
        nxt.prev = node;
    }

}
