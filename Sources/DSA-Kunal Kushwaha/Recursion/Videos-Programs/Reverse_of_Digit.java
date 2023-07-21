/*
WAP to print the reverse of a number.
*/

public class Reverse_of_Digit {
    //Approach 1 with taking a variable outside the function.
    static int sum=0;
    public static void reverse2(int n){
        if(n<1){
            return;
        }

        int rem=n%10;
        sum=sum*10 +rem;
        reverse2(n/10);
    }

    public static void main(String[]args){
        System.out.println(reverse(123));
        reverse2(123);
        System.out.println(sum);
    }

    public static int reverse(int n){
        int digits=(int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }
    public static int helper(int n, int digits){
        if(n%10==n){
            return n;
        }

        int rem=n%10;
        return rem *(int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
    }
}
