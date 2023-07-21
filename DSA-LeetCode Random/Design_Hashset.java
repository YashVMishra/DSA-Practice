//https://leetcode.com/problems/design-hashset/description/

import java.util.HashMap;

public class Design_Hashset {
    public static void main(String[] args) {
        MyHashSet ob = new MyHashSet();
        ob.add(1);
        ob.add(2);
        System.out.println(ob.contains(1));
        System.out.println(ob.contains(3));
        ob.add(2);
        System.out.println(ob.contains(2));
        ob.remove(2);
        System.out.println(ob.contains(2));
    }
}

class MyHashSet {
    HashMap<Integer, Integer> map;

    public MyHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, 1);
    }

    public void remove(int key) {
        map.remove(key);
    }

    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
