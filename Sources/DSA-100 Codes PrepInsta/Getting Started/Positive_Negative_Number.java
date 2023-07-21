//https://prepinsta.com/java-program/a-number-is-positive-or-negative-using-java/

// In this article, we will create a java program to check whether the number entered by the user is 
// positive or negative. The number is demonstrated as positive or negative by comparing the entered 
// number with the Zero(0). If the number entered by the user is greater than zero, then the number 
// is positive, else if the number is less than zero, then the number is negative and else the number 
// is zero.

// N > 0 then, number is Positive.
// N < 0 then, number is Negative.
// N = 0 then, number is Zero.

public class Positive_Negative_Number {
    public static void main(String[] args) {
        int num = 0;
        System.out.println(positiveNegative(num));
    }

    public static String positiveNegative(int num) {
        if (num == 0) {
            return "Zero";
        }

        else if (num > 0) {
            return "Positive";
        }

        return "Negative";
    }
}