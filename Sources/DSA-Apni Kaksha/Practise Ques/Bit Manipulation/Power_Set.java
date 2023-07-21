//https://practice.geeksforgeeks.org/problems/power-set4302/1s

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Power_Set {
    public static void main(String[] args) {
        System.out.println(all_possible_strings("abc"));
    }

    public static List<String> all_possible_strings(String str) {
        List<String> list = possible_strings("", str, new ArrayList<String>());
        Collections.sort(list);
        list.remove(0);
        return list;
    }

    public static List<String> possible_strings(String ans, String str, ArrayList<String> list) {
        if (str.length() == 0) {
            list.add(ans);
            return list;
        }

        char ch = str.charAt(0);

        possible_strings(ans, str.substring(1), list);
        possible_strings(ans + ch, str.substring(1), list);

        return list;
    }
}
