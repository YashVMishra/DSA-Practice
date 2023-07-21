//https://www.interviewbit.com/problems/subarray-with-given-xor/

import java.util.ArrayList;
import java.util.HashMap;

public class Subarray_with_given_XOR {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = { 4, 2, 2, 6, 4 };

        for (int i : arr) {
            A.add(i);
        }

        System.out.println(solve(A, 6));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;

        for (int i = 0; i < A.size(); i++) {
            xor = xor ^ A.get(i);

            if (xor == B) {
                count++;
            }

            if (map.get(xor ^ B) != null) {
                count += map.get(xor ^ B);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
