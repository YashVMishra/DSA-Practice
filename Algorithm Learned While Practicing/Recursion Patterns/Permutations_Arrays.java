import java.util.ArrayList;
import java.util.List;

public class Permutations_Arrays {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
        System.out.println(permute_2(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        generate(nums, ds, freq, ans);
        return ans;
    }

    // using backtracking and extra memory.
    public static void generate(int[] nums, List<Integer> ds, boolean[] freq, List<List<Integer>> ans) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
        }

        for (int i = 0; i < nums.length; i++) {
            if (freq[i] == false) {
                freq[i] = true;
                ds.add(nums[i]);
                generate(nums, ds, freq, ans);
                freq[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate_2(0, nums, ans);
        return ans;
    }

    // using swapping and no extra memory.
    public static void generate_2(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }

            ans.add(temp);
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            generate_2(index + 1, nums, ans);
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
