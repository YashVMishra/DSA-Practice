//https://practice.geeksforgeeks.org/problems/key-pair5616/1?page=1&company[]=SAP%20Labs&sortBy=submissions

import java.util.HashSet;

public class Key_Pair {
    public static void main(String[] args) {
        int N = 5;
        int X = 10;
        int Arr[] = { 1, 2, 4, 3, 6 };
        System.out.println(hasArrayTwoCandidates(Arr, N, X));
    }

    public static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(x - i)) {
                return true;
            }

            set.add(i);
        }

        return false;
    }
}
