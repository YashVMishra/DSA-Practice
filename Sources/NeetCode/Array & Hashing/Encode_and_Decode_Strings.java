import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encode_and_Decode_Strings {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("we", "say", ":", "yes", "!@#$%^&*()");

        System.out.println(encode(strs));
        System.out.println(decode(encode(strs)));
    }

    public static String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        int i = 0;

        // this helps in 2 digit number also
        while (i < str.length()) {
            // Find the next delimiter '#' starting from index i
            int hashPos = str.indexOf('#', i);

            // Parse the number between index i and hashPos
            int number = Integer.parseInt(str.substring(i, hashPos));

            // Extract the string of the parsed length starting after '#'
            ans.add(str.substring(hashPos + 1, hashPos + 1 + number));

            // Move the index past the extracted string
            i = hashPos + 1 + number;
        }

        return ans;
    }
}
