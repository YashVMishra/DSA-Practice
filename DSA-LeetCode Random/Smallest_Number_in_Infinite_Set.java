//https://leetcode.com/problems/smallest-number-in-infinite-set/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Smallest_Number_in_Infinite_Set {
    public static void main(String[] args) {
        SmallestInfiniteSet ob = new SmallestInfiniteSet();
        ob.addBack(2);
        System.out.println(ob.popSmallest());
        System.out.println(ob.popSmallest());
        System.out.println(ob.popSmallest());
        ob.addBack(1);
        System.out.println(ob.popSmallest());
        System.out.println(ob.popSmallest());
        System.out.println(ob.popSmallest());
    }
}

class SmallestInfiniteSet {
    ArrayList<Integer> list;
    HashSet<Integer> set;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        list = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            set.add(i);
            list.add(i);
        }
    }

    public int popSmallest() {
        int value = list.get(0);
        list.remove(0);
        set.remove(value);

        return value;
    }

    public void addBack(int num) {
        if (!set.contains(num)) {
            list.add(num);
            set.add(num);
            Collections.sort(list);
        }
    }
}
