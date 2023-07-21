//https://www.interviewbit.com/problems/repeat-and-missing-number-array/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Repeat_and_Missing_Number_Array {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 5, 3 };
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }

        System.out.println(repeatedNumber(list));
        System.out.println(repeatedNumber_2(list));
    }

    // this approach shows TLE.
    public static ArrayList<Integer> repeatedNumber(final List<Integer> arr) {
        // Write your code here

        // we are creating a copy of the original list as in ques
        // we cannot modify the given list.
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : arr) {
            temp.add(i);
        }

        sort(temp);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) - 1 != i) {
                ans.add(temp.get(i));
                ans.add(i + 1);
                break;
            }
        }

        return ans;
    }

    public static void sort(ArrayList<Integer> list) {
        int index = 0;
        while (index < list.size()) {
            int correctIndex = list.get(index) - 1;

            if (list.get(correctIndex) != list.get(index)) {
                swap(list, correctIndex, index);
            } else {
                index++;
            }
        }

        System.out.println(list);
    }

    public static void swap(ArrayList<Integer> list, int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    // uses extra DS.
    public static ArrayList<Integer> repeatedNumber_2(final List<Integer> arr) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i : arr) {
            if (set.contains(i)) {
                ans.add(i);
            }

            set.add(i);
        }

        for (int i = 1; i <= arr.size(); i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
