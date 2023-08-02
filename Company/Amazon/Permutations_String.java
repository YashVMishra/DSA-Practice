import java.util.ArrayList;
import java.util.List;

public class Permutations_String {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permute(String str) {
        List<List<Integer>> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder(str);
        recurPermute(temp, ans, 0);
        return ans;
    }

    public static void recurPermute(StringBuilder str, List<List<Integer>> ans, int index) {

    }

    public static void swap(StringBuilder str, int i, int j) {
        char ch1 = str.charAt(i);
        char ch2 = str.charAt(j);
        str.replace(i, i + 1, ch1);
    }
}
