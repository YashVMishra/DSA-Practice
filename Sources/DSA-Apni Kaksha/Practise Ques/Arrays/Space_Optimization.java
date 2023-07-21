//https://www.geeksforgeeks.org/space-optimization-using-bit-manipulations/

public class Space_Optimization {
    public static void main(String[] args) {
        spaceOptimize(2, 10);
    }

    public static void spaceOptimize(int num1, int num2) {
        int small = Math.min(num1, num2);
        int large = Math.max(num1, num2);

        int size = Math.abs(num1 - num2) + 1;
        int[] arr = new int[size];

        for (int i = small; i <= large; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                arr[i - small] = 1;
            }
        }

        for (int i = small; i <= large; i++) {
            if (arr[i - small] == 1) {
                System.out.print(i + "    ");
            }
        }
    }
}
