// Implementation of the HashMap provided by Java.

import java.util.*;

public class HashMap_Implementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of nodes.
        private int N; // number of buckets
        private LinkedList<Node>[] buckets; // N = buckets.length.

        @SuppressWarnings("unchecked")

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // converts the key into a hash value.
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // search the key in the LL of that particular bi.
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")

        // rehash function.
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];

                for (int j = 0; j < ll.size(); j++) {
                    Node temp = ll.get(i);
                    put(temp.key, temp.value);
                }
            }
        }

        // put function.
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); // dataindex in LL.

            if (di == -1) {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            else {
                Node temp = buckets[bi].get(di);
                temp.value = value;
            }

            double lambda = (double) (n / N);

            if (lambda > 2.0) {
                rehash();
            }
        }

        // get function.
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null;
            }

            else {
                Node temp = buckets[bi].get(di);
                return temp.value;
            }
        }

        // return true if key in present in the map else false.
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return false;
            }

            else {
                return true;
            }
        }

        // removes the node of the given key from the map
        // and returns its value.
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null;
            }

            else {
                Node temp = buckets[bi].remove(di);
                n--;
                return temp.value;
            }
        }

        // return true if map is empty else false.
        public boolean isEmpty() {
            return n == 0;
        }

        // returns a list of all the keys in the map.
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];

                for (int j = 0; j < ll.size(); j++) {
                    Node temp = ll.get(j);
                    keys.add(temp.key);
                }
            }

            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 190);
        map.put("Canada", 180);
        map.put("US", 150);
        map.put("China", 200);

        ArrayList<String> list_1 = map.keySet();
        for (int i = 0; i < list_1.size(); i++) {
            System.out.println(list_1.get(i) + " " + map.get(list_1.get(i)));
        }

        map.remove("Canada");
        System.out.println();

        ArrayList<String> list_2 = map.keySet();
        for (int i = 0; i < list_2.size(); i++) {
            System.out.println(list_2.get(i) + " " + map.get(list_2.get(i)));
        }
    }
}