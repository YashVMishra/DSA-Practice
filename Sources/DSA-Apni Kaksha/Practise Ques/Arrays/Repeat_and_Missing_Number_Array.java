//https://www.interviewbit.com/problems/repeat-and-missing-number-array/

import java.util.HashSet;
import java.util.ArrayList;

public class Repeat_and_Missing_Number_Array {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);

        System.out.println(repeatedNumber(list));
    }

    public static ArrayList<Integer> repeatedNumber(final ArrayList<Integer> A) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (hs.contains(A.get(i))) {
                list.add(A.get(i));
            }

            hs.add(A.get(i));
        }

        for (int i = 1; i <= A.size(); i++) {
            if (!hs.contains(i)) {
                list.add(i);
            }
        }

        return list;

    }
}
