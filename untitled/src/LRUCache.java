//import leetcode.NodeList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public class NodeList {
        public NodeList next;
        public NodeList prev;
        public int val;

        public NodeList(int val) {
            this.val = val;

        }
    }
        int capacity;
        NodeList head;
        NodeList tail;
        Map<Integer, NodeList> values = new HashMap<>();


        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new NodeList(0);
            tail = new NodeList(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!values.containsKey(key))
                return -1;
            int res = values.get(key).val;
            removeNode(values.get(key));
            addToFront(values.get(key));
            return res;
        }

        public void put(int key, int value) {
            values.put(key, new NodeList(value));
            if (values.containsKey(key)) {
                removeNode(values.get(key));
                addToFront(new NodeList(key));
            } else {
                addToFront(new NodeList(value));
            }
        }

        private void addToFront(NodeList node) {

            NodeList headNext = head.next;
            head.next = node;
            node.prev = head;

            node.next = headNext;
            if (values.size() == capacity) {
                NodeList prev = tail.prev.prev;
                prev.next = tail;
                tail.prev = prev;
                values.remove(prev.val);
            }
            // values.put(node)
        }

        private void removeNode(NodeList node) {
            NodeList prev = head;
            while (prev.next.val != node.val || prev.next == tail) {
                prev = prev.next;
            }
            if (prev.next == tail)
                return;
            else {
                prev.next = prev.next.next;
                prev.next.prev = prev;
            }
            values.remove(node.val);
        }
    }
