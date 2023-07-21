import java.util.ArrayList;
import java.util.Arrays;

public class Non_Repeating {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(non_repeating(new int[] { 2, 3, 7, 9, 11, 2, 3, 11 })));
    }

    public static int[] non_repeating(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1;) {
            if (arr[i] == arr[i + 1]) {
                i += 2;
            }

            else {
                list.add(arr[i]);
                i = i + 1;
            }
        }

        if (list.size() != 2) {
            list.add(arr[arr.length - 1]);
        }

        int[] ans = new int[2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
