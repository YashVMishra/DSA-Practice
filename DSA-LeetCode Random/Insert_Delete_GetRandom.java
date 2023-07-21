//https://leetcode.com/problems/insert-delete-getrandom-o1/description/

import java.util.ArrayList;
import java.util.HashMap;

public class Insert_Delete_GetRandom {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(3);
        boolean param_2 = obj.insert(2);
        boolean param_3 = obj.remove(3);
        int param_4 = obj.getRandom();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

}

class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        map.remove(val);

        // imp case.
        if (index == list.size() - 1) {
            list.remove(list.size() - 1);
            return true;
        }

        list.set(index, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        map.put(list.get(index), index);
        return true;
    }

    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}
