//Count the number of permutations of a string.

public class Number_of_Permutations {
    public static void main(String[] args) {
        System.out.println(permutations("abc", ""));
    }

    public static int permutations(String str, String ans) {
        if (str.isEmpty()) {
            // System.out.print(ans + " ");
            return 1;
        }

        char ch = str.charAt(0);
        int count = 0;

        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
            count = count + permutations(str.substring(1), (first + ch + second));
        }

        return count;
    }
}
