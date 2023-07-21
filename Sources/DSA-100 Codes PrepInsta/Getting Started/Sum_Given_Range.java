//https://prepinsta.com/java-program/sum-of-numbers-in-a-given-range-using-java/

// Given the range as integer input, the objective is to find the Sum of all the Numbers that lay in 
// the given interval using different methods. To do so we basically iterate from the base interval 
// to the final interval and keep adding the number. Here are some of the methods to solve the above 
// mentioned problem in Java Language.

public class Sum_Given_Range {
    public static void main(String[] args) {
        int llimit = 10;
        int ulimit = 20;
        System.out.println(sum(llimit, ulimit));
        System.out.println(sum_2(llimit, ulimit));
        System.out.println(sum_3(llimit, ulimit));
    }

    // using loop.
    public static long sum(int llimit, int ulimit) {
        long result = 0;

        for (int i = llimit; i <= ulimit; i++) {
            result += i;
        }

        return result;
    }

    // using formula
    // remember to add the llimit at the last.
    public static long sum_2(int llimit, int ulimit) {
        long temp1 = (llimit * (llimit + 1)) / 2;
        long temp2 = (ulimit * (ulimit + 1)) / 2;

        return temp2 - temp1 + llimit;
    }

    // using recursion.
    public static long sum_3(int llimit, int ulimit) {
        if (llimit == ulimit) {
            return llimit;
        }

        long result = llimit + sum_3(llimit + 1, ulimit);

        return result;
    }
}
