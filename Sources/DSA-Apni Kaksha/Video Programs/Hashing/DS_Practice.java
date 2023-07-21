import java.util.*;

public class DS_Practice {
    public static void main(String[] args) {
        HashSet_Example();
        HashMap_Example();
    }

    public static void HashSet_Example() {
        System.out.println("HASHSET EXAMPLE");
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= 10; i++) {
            set.add(i);
        }

        if (set.contains(9)) {
            System.out.println("Found");
        }

        set.remove(9);

        if (!set.contains(9)) {
            System.out.println("Not found");
        }

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
    }

    public static void HashMap_Example() {
        System.out.println("HASHMAP EXAMPLE");
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);

        System.out.println(map);

        if (map.containsKey('A')) {
            System.out.println("Key Exist");
        }

        else {
            System.out.println("Key does not exist");
        }

        map.remove('A');

        if (map.containsKey('A')) {
            System.out.println("Key Exist");
        }

        else {
            System.out.println("Key does not exist");
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            System.out.print(e.getKey() + " -> ");
            System.out.print(e.getValue());
            System.out.println();
        }

        Set<Character> set = map.keySet();

        for (Character ch : set) {
            System.out.print(ch + " ");
        }

        System.out.println();
    }
}