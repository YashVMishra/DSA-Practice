//https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class Array_Differ_With_At_Most_k {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 6 }, 5, 6, 1));
    }

    public static int search(int arr[], int n, int x, int k) {
        // Complete the function

        for (int i = 0; i < n;) {
            if (arr[i] == x) {
                return i;
            }

            i = i + Math.max(1, Math.abs(arr[i] - x) / k);
        }

        return -1;
    }
}
