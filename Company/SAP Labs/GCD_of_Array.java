// https://practice.geeksforgeeks.org/problems/gcd-of-array0614/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// The GCD of three or more numbers equals the product of the prime factors common to all 
// the numbers, but it can also be calculated by repeatedly taking the GCDs of pairs of numbers. 

public class GCD_of_Array {
    public static void main(String[] args) {
        int arr[] = { 2, 6, 4 };
        System.out.println(gcd(arr.length, arr));
    }

    public static int gcd(int N, int arr[]) {
        // code here.
        int ans = arr[0];
        for (int i = 1; i < N; i++) {
            ans = gcd(ans, arr[i]);

            if (ans == 1) {
                return 1;
            }
        }

        return ans;
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}
