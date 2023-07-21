/*
WAP to print number from N to 1 and 1 to N.
*/

public class N_to_1_1_to_N {
    public static void main(String[] args) {
        printnumbers(5);
        printnumbers2(5);
    }

    public static void printnumbers(int n) {
        if (n < 1) {
            return;
        }

        System.out.print(n + " ");
        printnumbers(n - 1);
    }

    public static void printnumbers2(int n) {
        if (n < 1) {
            return;
        }

        printnumbers2(n - 1);
        System.out.print(n + " ");
    }
}
