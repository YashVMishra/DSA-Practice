import java.util.ArrayList;
import java.util.List;

public class Subsets_Strings {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(subsets(str));
    }

    public static List<String> subsets(String str) {
        List<String> ans = new ArrayList<>();
        generate(str, "", ans);
        return ans;
    }

    // p stands for processed string and up stands for un-processed string.
    public static void generate(String p, String up, List<String> ans) {
        if (p.isEmpty()) {
            ans.add(up);
            return;
        }

        char ch = p.charAt(0);

        // take
        generate(p.substring(1), up + ch, ans);

        // do not take
        generate(p.substring(1), up, ans);
    }
}
