//https://leetcode.com/problems/count-and-say/description/

public class Count_Say {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        // for recursive solution.
        // return helper(n, "1");

        String temp = "1";
        for (int i = n; i > 1; i--) {
            temp = count(temp);
        }

        return temp;
    }

    // recursive method to find each nth count-and-say number.
    public static String helper(int n, String str) {
        if (n == 1) {
            return str;
        }

        String temp = count(str);

        return helper(n - 1, temp);
    }

    // forming the number everytime like
    // 21 to 1211
    public static String count(String str) {
        String temp = "";
        int count = 0;

        for (int i = 0; i < str.length(); i = i + count) {
            count = 0;

            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }

                else {
                    break;
                }
            }

            temp = temp + Integer.toString(count) + str.charAt(i);
        }

        return temp;
    }

}