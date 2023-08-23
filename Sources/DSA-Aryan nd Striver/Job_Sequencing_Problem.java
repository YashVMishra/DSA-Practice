// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

import java.util.Arrays;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class Job_Sequencing_Problem {
    public static void main(String[] args) {
        int n = 5;
        Job arr[] = new Job[n];
        arr[0] = new Job(1, 2, 100);
        arr[1] = new Job(2, 1, 19);
        arr[2] = new Job(3, 2, 27);
        arr[3] = new Job(4, 1, 25);
        arr[4] = new Job(5, 1, 15);

        int[] ans = JobScheduling(arr, n);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] JobScheduling(Job arr[], int n) {
        // Your code here
        int count = 0;
        int profit = 0;
        int[] ans = new int[2];
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int maxDeadline = Integer.MIN_VALUE;

        for (Job temp : arr) {
            maxDeadline = Math.max(maxDeadline, temp.deadline);
        }

        boolean[] slots = new boolean[maxDeadline];

        for (int i = 0; i < arr.length; i++) {
            if (slots[arr[i].deadline - 1] == false) {
                slots[arr[i].deadline - 1] = true;
                count++;
                profit += arr[i].profit;
            } else {
                for (int j = arr[i].deadline - 2; j >= 0; j--) {
                    if (slots[j] == false) {
                        slots[j] = true;
                        count++;
                        profit += arr[i].profit;
                        break;
                    }
                }
            }
        }

        ans[0] = count;
        ans[1] = profit;

        return ans;
    }
}
