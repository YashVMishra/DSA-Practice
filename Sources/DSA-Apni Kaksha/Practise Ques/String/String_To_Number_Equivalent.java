//https://www.geeksforgeeks.org/convert-sentence-equivalent-mobile-numeric-keypad-sequence/

import java.util.Scanner;

public class String_To_Number_Equivalent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = { "2", "22", "222",
                "3", "33", "333",
                "4", "44", "444",
                "5", "55", "555",
                "6", "66", "666",
                "7", "77", "777", "7777",
                "8", "88", "888",
                "9", "99", "999", "9999" };

        System.out.println("Enter the string in uppercase only.");
        String str = sc.nextLine();

        System.out.println(numberEquivalent(arr, str));
        sc.close();
    }

    static String numberEquivalent(String[] arr, String str) {

        String output = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                output += '0';
            }

            else {
                output += arr[str.charAt(i) - 'A'];
            }
        }

        return output;
    }
}
