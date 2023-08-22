// https://leetcode.com/problems/excel-sheet-column-title/description/

public class Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    // for intuition see notes section.
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int temp = columnNumber;

        while (temp > 0) {
            temp--;
            sb.append((char) (temp % 26 + 'A'));
            temp /= 26;
        }

        // make sure to reverse the string.
        return sb.reverse().toString();
    }
}
