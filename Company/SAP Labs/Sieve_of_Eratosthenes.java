// https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1?page=2&company[]=SAP%20Labs&sortBy=submissions

import java.util.ArrayList;

public class Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        int N = 11;
        System.out.println(sieveOfEratosthenes(N));
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int N) {
        // code here
        boolean[] primes = new boolean[N + 1];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 2; i * i < primes.length; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j < primes.length; j = j + i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
