//https://leetcode.com/problems/shuffle-an-array/description/

import java.util.Arrays;
import java.util.Random;

public class Shuffle_Array_Class {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
    }
}

class Solution {

    int[] temp;

    public Solution(int[] nums) {
        temp = nums;
    }

    public int[] reset() {
        return temp;
    }

    public int[] shuffle() {
        int[] shuffle = temp.clone();

        for (int i = shuffle.length - 1; i >= 0; i--) {
            int index = new Random().nextInt(i + 1);
            int swap = shuffle[i];
            shuffle[i] = shuffle[index];
            shuffle[index] = swap;
        }

        return shuffle;
    }
}
