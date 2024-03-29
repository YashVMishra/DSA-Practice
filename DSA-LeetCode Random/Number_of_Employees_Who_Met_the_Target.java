// https://leetcode.com/problems/number-of-employees-who-met-the-target/description/

public class Number_of_Employees_Who_Met_the_Target {
    public static void main(String[] args) {
        int[] hours = { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
        int target = 10;

        System.out.println(numberOfEmployeesWhoMetTarget(hours, target));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;

        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }

        return count;
    }
}
