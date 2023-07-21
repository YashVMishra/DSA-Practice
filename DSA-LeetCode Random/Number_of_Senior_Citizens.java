//https://leetcode.com/problems/number-of-senior-citizens/

public class Number_of_Senior_Citizens {
    public static void main(String[] args) {
        String[] details = { "1313579440F2036", "2921522980M5644" };
        System.out.println(countSeniors(details));
    }

    public static int countSeniors(String[] details) {
        int count = 0;

        for (String str : details) {
            String temp = str.substring(11, 13);
            int age = Integer.parseInt(temp);

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}
