//https://leetcode.com/problems/first-bad-version/description/?envType=study-plan&id=level-1

// Modify the isBadVersion method and the main method to suit our problem
// since the real problem involves API calling we cannot do it here.
// see the ques and you will understand.

public class First_Bad_Version {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int ans = 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                ans = mid;
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isBadVersion(int n) {
        boolean[] temp = new boolean[10];

        for (int i = 0; i < 5; i++) {
            temp[i] = false;
        }

        for (int i = 5; i < 10; i++) {
            temp[i] = true;
        }

        return temp[n];
    }
}
