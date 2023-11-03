// https://leetcode.com/problems/build-an-array-with-stack-operations/description/?envType=daily-question&envId=2023-11-03

import java.util.ArrayList;
import java.util.List;

public class Build_an_Array_With_Stack_Operations {
    public static void main(String[] args) {
        int[] target = { 1, 2 };
        int n = 4;

        System.out.println(buildArray(target, n));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;

        // i is for the stream.
        // index is for the target array.
        for (int i = 1; i <= n; i++) {
            int num = target[index];

            if (num == i) {
                ans.add("Push");
                index++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }

            if (index == target.length) {
                break;
            }
        }

        return ans;
    }
}
