//https://prepinsta.com/java-program/a-number-is-even-or-odd-using-java/

// Given an integer input the objective is to write a Java code to Check Whether a Number is Even or 
// Odd. To do so the main idea is to divide the number by 2 and check if it’s divisible or not. 
// It’s an Even number is it’s perfectly divisible by 2 or an Odd number otherwise.

public class Even_Odd {
    public static void main(String[] args) {
        int num = 72;
        System.out.println(evenOdd(num));
        System.out.println(evenOdd_2(num));
    }

    public static String evenOdd(int num) {
        if (num % 2 == 0) {
            return "Even";
        }

        return "Odd";
    }

    public static String evenOdd_2(int num) {
        if ((num & 1) == 1) {
            return "Odd";
        }

        return "Even";
    }
}
