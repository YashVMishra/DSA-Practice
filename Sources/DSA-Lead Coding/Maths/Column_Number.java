//https://leetcode.com/problems/excel-sheet-column-title/description/

public class Column_Number {
    public static void main(String[] args) {
        System.out.println(convertToTitle(703));
    }

    public static String convertToTitle(int columnNumber) {
        String ans = "";

        int temp = columnNumber;

        while (temp != 0) {
            char ch = (char) (65 + (temp - 1) % 26);

            ans = ch + ans;

            temp = (temp - 1) / 26;
        }

        return ans;
    }
}
