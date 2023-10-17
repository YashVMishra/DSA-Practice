import java.util.HashSet;
import java.util.Scanner;

public class Counting_Vowels {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('0');
        vowels.add('U');

        for (char ch : str.toCharArray()) {
            if (vowels.contains(ch)) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}