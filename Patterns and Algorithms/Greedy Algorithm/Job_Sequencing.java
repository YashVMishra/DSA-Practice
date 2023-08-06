import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Job_Sequencing {
    public static void main(String[] args) {
        Job[] arr = new Job[5];
        arr[0] = new Job(1, 2, 100);
        arr[1] = new Job(2, 1, 19);
        arr[2] = new Job(3, 2, 27);
        arr[3] = new Job(4, 1, 25);
        arr[4] = new Job(5, 1, 15);

        System.out.println(Arrays.toString(JobScheduling(arr, 5)));
    }

    static class Job {
        int profit, deadline;
        int id;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static int[] JobScheduling(Job arr[], int n) {
        // Your code here
        // to store the answer i.e. profit and the number of jobs
        int[] ans = new int[2];

        // create an extra list to sort the arr in terms of the profit.
        ArrayList<Job> list = new ArrayList<>();

        // adding the arr elements in the list.
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }

        // sorting the list acc to profit.
        Collections.sort(list, (a, b) -> b.profit - a.profit);

        // modifying the arr array.
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }

        // finding the max deadline/
        int max_deadline = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max_deadline = Math.max(arr[i].deadline, max_deadline);
        }

        // making a boolean array of the same size as
        // max_deadline.
        boolean[] time = new boolean[max_deadline];

        int max_profit = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {

            // if the deadline-1 is equal to the index then we take
            // that job and update our count and profit
            // and make that index of time as false
            if (time[arr[i].deadline - 1] == false) {
                time[arr[i].deadline - 1] = true;
                max_profit += arr[i].profit;
                count++;
            }

            else {

                // this loop is to check whether there is any index left of that
                // index which have any false value if yes then fill that
                // and gain make it true and update the profit and count.
                for (int j = arr[i].deadline - 1; j >= 0; j--) {
                    if (time[j] == false) {
                        if (j < arr[i].deadline - 1) {
                            time[j] = true;
                            max_profit += arr[i].profit;
                            count++;
                            break; // break is for as we need only one such index everytime.
                        }
                    }
                }
            }
        }

        ans[0] = count;
        ans[1] = max_profit;

        return ans;
    }
}
