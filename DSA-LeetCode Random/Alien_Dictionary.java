//https://leetcode.com/problems/verifying-an-alien-dictionary/description/

public class Alien_Dictionary {
    public static void main(String[] args) {
        String[] words = { "hello", "leetcode" };
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            int len = Math.min(curr.length(), next.length());

            // important case for inputs like
            // words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
            if (len != curr.length() && curr.startsWith(next)) {
                return false;
            }

            for (int j = 0; j < len; j++) {
                if (order.indexOf(curr.charAt(j)) > order.indexOf(next.charAt(j))) {
                    return false;
                }

                if (order.indexOf(curr.charAt(j)) < order.indexOf(next.charAt(j))) {
                    break;
                }
            }
        }

        return true;
    }
}
