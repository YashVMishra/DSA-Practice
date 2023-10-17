import java.util.Scanner;

public class Reverse_Each_Word {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] words = str.split(" ");
        String rev = "";

        for (String word : words) {
            rev += reverse(word) + " ";
        }

        System.out.println(rev);
        sc.close();
    }

    private static String reverse(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        return rev;
    }
}
