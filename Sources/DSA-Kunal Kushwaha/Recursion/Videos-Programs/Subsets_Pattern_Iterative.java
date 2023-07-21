import java.util.ArrayList;

public class Subsets_Pattern_Iterative {
    public static void main(String[] args) {
        System.out.println(subset(new int[] { 1, 2, 3, 4 }));
    }

    public static ArrayList<ArrayList<Integer>> subset(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>());

        for (int num : arr) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> internal = new ArrayList<>(ans.get(i));
                internal.add(num);
                ans.add(internal);
            }
        }

        return ans;
    }
}
