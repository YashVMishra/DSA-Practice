//https://leetcode.com/problems/subsets/

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 3 }));
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());

        for (int a : nums) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> temp = new ArrayList<>(list.get(i));
                temp.add(a);
                list.add(temp);
            }
        }

        return list;
    }
}
