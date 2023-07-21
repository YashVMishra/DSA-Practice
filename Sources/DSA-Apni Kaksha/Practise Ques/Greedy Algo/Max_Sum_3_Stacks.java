//https://practice.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class Max_Sum_3_Stacks {
    public static void main(String[] args) {
        int N1 = 3;
        int N2 = 4;
        int N3 = 2;
        int[] S1 = { 4, 2, 3 };
        int[] S2 = { 1, 1, 2, 3 };
        int[] S3 = { 1, 4 };

        System.out.println(maxEqualSum(N1, N2, N3, S1, S2, S3));
    }

    public static int maxEqualSum(int n1, int n2, int n3, int[] stack1, int[] stack2, int[] stack3) {
        // code here
        int sum1 = 0, sum2 = 0, sum3 = 0;

        // Finding the initial sum of stack1.
        for (int i = 0; i < n1; i++)
            sum1 += stack1[i];

        // Finding the initial sum of stack2.
        for (int i = 0; i < n2; i++)
            sum2 += stack2[i];

        // Finding the initial sum of stack3.
        for (int i = 0; i < n3; i++)
            sum3 += stack3[i];

        // As given in question, first element is top
        // of stack..
        int top1 = 0, top2 = 0, top3 = 0;
        while (true) {
            // If any stack is empty
            if (top1 == n1 || top2 == n2 || top3 == n3)
                return 0;

            // If sum of all three stack are equal.
            if (sum1 == sum2 && sum2 == sum3)
                return sum1;

            // Finding the stack with maximum sum and
            // removing its top element.
            if (sum1 >= sum2 && sum1 >= sum3)
                sum1 -= stack1[top1++];

            else if (sum2 >= sum1 && sum2 >= sum3)
                sum2 -= stack2[top2++];

            else if (sum3 >= sum2 && sum3 >= sum1)
                sum3 -= stack3[top3++];
        }
    }
}
