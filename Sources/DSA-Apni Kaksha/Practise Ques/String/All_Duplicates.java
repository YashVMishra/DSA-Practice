
import java.util.Scanner;

public class All_Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string.");
        String str = sc.nextLine();

        int[] arr = new int[256];
        arr = duplicate(arr, str);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                System.out.println("Count of " + (char) (i) + " is " + arr[i]);
            }
        }

        sc.close();
    }

    static int[] duplicate(int[] arr, String str) {

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }

        return arr;
    }
}
