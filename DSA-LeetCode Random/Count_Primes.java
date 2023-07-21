//https://leetcode.com/problems/count-primes/description/

import java.util.Arrays;

public class Count_Primes {
    public static void main(String[] args) {
        int n = 10;

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, false);
        System.out.println(SOE(n, primes));

        System.out.println(countPrimes(n));
    }

    // this method shows TLE
    // using both the helper function
    // Still this method shows TLE.
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime_2(i)) {
                count++;
            }
        }

        return count;
    }

    // this method is called Sieve of Eratosthenes
    public static int SOE(int n, boolean[] primes) {
        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < primes.length - 1; i++) {
            if (!primes[i]) {
                count++;
            }
        }

        return count;
    }

    // helper function.
    public static boolean isPrime(int n) {

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // helper function 2
    public static boolean isPrime_2(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}