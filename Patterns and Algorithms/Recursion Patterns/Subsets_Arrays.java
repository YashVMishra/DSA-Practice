import java.util.ArrayList;
import java.util.List;

public class Subsets_Arrays {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(generateUsingLoop(nums));
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, nums, ans, new ArrayList<>());
        return ans;
    }

    // recursive approach.
    public static void generate(int index, int[] nums, List<List<Integer>> ans, List<Integer> current) {
        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generate(i + 1, nums, ans, current);
            current.remove(current.size() - 1);
        }
    }

    // ---------------------------------------------------------------------------------

    // using loop.
    public static List<List<Integer>> generateUsingLoop(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num : nums) {
            int size = outer.size();

            for (int i = 0; i < size; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }
}