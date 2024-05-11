// https://leetcode.com/problems/k-th-smallest-prime-fraction/description/?envType=daily-question&envId=2024-05-10

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Group {
    int x;
    int y;
    double z;

    public Group(int x, int y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}

public class K_th_Smallest_Prime_Fraction {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int k = 3;
        int[] ans = kthSmallestPrimeFraction(arr, k);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] ans = new int[2];
        List<Group> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                list.add(new Group(arr[i], arr[j], (double) arr[i] / arr[j]));
            }
        }

        Collections.sort(list, (a, b) -> Double.compare(a.z, b.z));
        ans[0] = list.get(k - 1).x;
        ans[1] = list.get(k - 1).y;

        return ans;
    }

    // --------------------------------------------------------------------------------

    public static int[] kthSmallestPrimeFraction_2(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double div = (double) arr[i] / arr[j];
                pq.offer(new double[] { div, (double) arr[i], (double) arr[j] });
                if (pq.size() > k)
                    pq.poll();
            }
        }

        double[] vec = pq.peek();
        int[] result = new int[2];
        result[0] = (int) vec[1];
        result[1] = (int) vec[2];
        return result;
    }

    // --------------------------------------------------------------------------------

    public static int[] kthSmallestPrimeFraction_3(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (int i = 0; i < n; i++) {
            pq.offer(new double[] { 1.0 * arr[i] / arr[n - 1], (double) i, (double) (n - 1) });
        }

        int smallest = 1;

        while (smallest < k) {
            double[] vec = pq.poll();

            int i = (int) vec[1];
            int j = (int) vec[2] - 1;

            pq.offer(new double[] { 1.0 * arr[i] / arr[j], (double) i, (double) j });
            smallest++;
        }

        double[] vec = pq.peek();
        int i = (int) vec[1];
        int j = (int) vec[2];
        return new int[] { arr[i], arr[j] };
    }
}
