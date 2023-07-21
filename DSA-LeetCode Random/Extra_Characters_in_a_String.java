public class Extra_Characters_in_a_String {
    public static void main(String[] args) {
        String s = "dwmodizxvvbosxxw";
        String[] dictionary = { "ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy",
                "tskz", "ds", "kzbu" };
        System.out.println(minExtraChar(s, dictionary));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int tempLength = 0;
        for (String temp : dictionary) {
            int count = count(s, temp);
            tempLength += count * temp.length();
        }

        return s.length() - tempLength;
    }

    public static int count(String str, String temp) {
        int count = 0;
        int subStrLength = temp.length();

        for (int i = 0; i <= str.length() - subStrLength; i++) {
            if (str.substring(i, i + subStrLength).equals(temp)) {
                count++;
            }
        }

        return count;
    }
}
