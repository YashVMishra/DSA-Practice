public class Get_Equal_Substrings_Within_Budget {
    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;

        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();

        int maxLen = 0;
        int currCost = 0;

        int i = 0, j = 0;
        while (j < n) {
            currCost += Math.abs(s.charAt(j) - t.charAt(j));

            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}
