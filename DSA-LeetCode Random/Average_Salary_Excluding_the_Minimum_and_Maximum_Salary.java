//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/

public class Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {
    public static void main(String[] args) {
        int[] salary = { 4000, 3000, 1000, 2000 };
        System.out.println(average(salary));
    }

    public static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i : salary) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            sum += i;
        }

        return (double) (sum - max - min) / (salary.length - 2);
    }
}
