// https://leetcode.com/problems/design-hashmap/description/?envType=daily-question&envId=2023-10-04

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {
    private int[] arr;

    public MyHashMap() {
        arr = new int[10000001];
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        return arr[key];
    }

    public void remove(int key) {
        arr[key] = -1;
    }
}

class MyHashMap_2 {
    private List<Pair>[] buckets;
    int size = 10000;

    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap_2() {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int bucketNo = key % size; // working as a hash function.
        List<Pair> chain = buckets[bucketNo];
        for (Pair pair : chain) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        chain.add(new Pair(key, value));
    }

    public int get(int key) {
        int bucketNo = key % size;
        List<Pair> chain = buckets[bucketNo];
        for (Pair pair : chain) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int bucketNo = key % size;
        List<Pair> chain = buckets[bucketNo];
        for (Pair pair : chain) {
            if (pair.key == key) {
                chain.remove(pair);
                return;
            }
        }
    }
}

public class Design_HashMap {
    public static void main(String[] args) {
        MyHashMap_2 hashMap = new MyHashMap_2();
        hashMap.put(1, 1);
        hashMap.put(2, 2);

        System.out.println(hashMap.get(1)); // returns 1
        System.out.println(hashMap.get(3)); // returns -1 (not found)

        hashMap.put(2, 1); // update the existing value
        System.out.println(hashMap.get(2)); // returns 1

        hashMap.remove(2); // remove the mapping for 2
        System.out.println(hashMap.get(2)); // returns -1 (not found)
    }
}
