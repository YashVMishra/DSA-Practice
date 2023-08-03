// for reference see KK video.

import java.util.ArrayList;
import java.util.List;

public class Permutations_String {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(permute(str));
    }

    public static List<String> permute(String str) {
        List<String> ans = new ArrayList<>();
        generate(str, "", ans);
        return ans;
    }

    // p stands for processed string and up stands for un-processed string.
    public static void generate(String p, String up, List<String> ans) {
        if (p.length() == 0) {
            ans.add(up);
            return;
        }

        char ch = p.charAt(0);
        for (int i = 0; i <= up.length(); i++) {
            String left = up.substring(0, i);
            String right = up.substring(i, up.length());

            generate(p.substring(1), left + ch + right, ans);
        }
    }
}
