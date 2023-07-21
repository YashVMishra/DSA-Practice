//https://leetcode.com/problems/largest-number/description/

public class Largest_Number {
    public static void main(String[] args) {

        String[] arr = { "1", "34", "3", "98", "9", "76", "45", "4" };
        largest(arr);

        String ans = "";

        for (int i = 0; i < arr.length; i++) {
            ans = ans + arr[i];
        }

        int size = ans.length();

        String check = "";
        for (int i = 0; i < size; i++) {
            check = check + "0";
        }

        if (ans.compareTo(check) == 0) {
            System.out.println("0");
        }

        else {
            System.out.println(ans);
        }

        // System.out.println(Arrays.toString(arr));
    }

    public static void largest(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                String str_1 = arr[i] + arr[j];
                String str_2 = arr[j] + arr[i];

                if (str_1.compareTo(str_2) < 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
