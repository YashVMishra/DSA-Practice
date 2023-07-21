//https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/description/

public class Maximum_Number_of_Achievable_Transfer_Requests {
    static int ans = 0;

    public static void main(String[] args) {
        int n = 5;
        int[][] requests = { { 0, 1 }, { 1, 0 }, { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 } };
        System.out.println(maximumRequests(n, requests));
    }

    public static int maximumRequests(int n, int[][] requests) {
        int[] transfers = new int[n];
        backTrack(0, 0, transfers, requests);
        return ans;
    }

    public static void backTrack(int index, int count, int[] transfers, int[][] requests) {
        if (index == requests.length) {
            for (int i : transfers) {
                if (i != 0)
                    return;
            }

            ans = Math.max(ans, count);
            return;
        }

        transfers[requests[index][0]]--;
        transfers[requests[index][1]]++;
        backTrack(index + 1, count + 1, transfers, requests);

        transfers[requests[index][0]]++;
        transfers[requests[index][1]]--;
        backTrack(index + 1, count, transfers, requests);

    }
}
