//https://leetcode.com/problems/excel-sheet-column-number/description/

public class Excel_Column_Number {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }

    public static int titleToNumber(String columnTitle) {
        int colNumber = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            colNumber = (colNumber * 26) + (columnTitle.charAt(i) - 64);
        }

        return colNumber;
    }
}
