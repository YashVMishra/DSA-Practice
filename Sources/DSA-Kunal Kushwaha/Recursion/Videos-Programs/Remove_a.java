
//Given a string , remove every 'a' from it and print it.
import java.util.Scanner;

public class Remove_a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();
        System.out.println(remove_ans_in_func_call(str, ""));
        System.out.println(remove_ans_not_in_func_call(str));
        sc.close();
    }

    public static String remove_ans_in_func_call(String str, String ans) {
        // System.out.println(str);
        if (str.length() == 0) {
            return ans;
        }

        if (str.charAt(0) != 'a' && str.charAt(0) != 'A') {
            ans = ans + str.charAt(0);
        }

        return remove_ans_in_func_call(str.substring(1), ans);
    }

    public static String remove_ans_not_in_func_call(String str) {
        String ans = "";

        if (str.length() == 0) {
            return "";
        }

        if (str.charAt(0) != 'a' && str.charAt(0) != 'A') {
            ans = ans + str.charAt(0);
        }

        return ans + remove_ans_not_in_func_call(str.substring(1));

    }
}
