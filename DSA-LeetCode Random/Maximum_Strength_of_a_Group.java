import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Maximum_Strength_of_a_Group {
    public static void main(String[] args) {
        int[] nums = { 3, -1, -5, 2, 5, -9 };
        System.out.println(maxStrength(nums));
    }

    public static long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int i : nums) {
            if (i < 0) {
                less.add(i);
            }

            else if (i > 0) {
                greater.add(i);
            }
        }

        Collections.sort(less);
        Collections.sort(greater);

        long ans1 = 0;
        for (int i = 0; i < less.size(); i++) {
            if (i == 0) {
                ans1 = (long) less.get(i);
            }

            else {
                if (less.size() % 2 == 0) {
                    long neg = less.get(i);
                    ans1 = ans1 * neg;
                }

                else {
                    if (i < less.size() - 1) {
                        long neg = less.get(i);
                        ans1 = ans1 * neg;
                    }
                }
            }
        }

        long ans2 = 0;
        for (int i = 0; i < greater.size(); i++) {
            if (ans2 == 0) {
                ans2 = (long) greater.get(i);
            }

            else {
                long pos = (long) greater.get(i);
                ans2 = ans2 * pos;
            }
        }

        if (ans1 > 0 && ans2 > 0) {
            return ans1 * ans2;
        }

        else if (ans1 > 0) {
            return ans1;
        }

        else if (ans2 > 0) {
            return ans2;
        }

        else {
            return 0;
        }
    }
}
