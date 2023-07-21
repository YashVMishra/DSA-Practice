//https://practice.geeksforgeeks.org/problems/prime-number2314/1?page=1&company[]=SAP%20Labs&sortBy=submissions

public class Prime_Number {
    public static void main(String[] args) {
        int N = 31;
        System.out.println(isPrime(N));
    }

    public static int isPrime(int N) {

        // important edge case since loop is starting from 2.
        if (N == 1) {
            return 1;
        }

        // since we are going till sqrt of N so be careful to run the loop till
        // srqt of N that is i <= Math.sqrt(N) -> " = " sign is important.
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}
