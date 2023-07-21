/*
WAP to count the number of zeroes in a digit.
*/

public class Count_of_Zeroes {
    public static void main(String[]args){
        System.out.println(count(203040506));
    }

    public static int count(int n){
        return helper(n,0);
    }

    public static int helper(int n, int c){
        if(n==0){
            return c;
        }

        if(n%10==0){
            return helper(n/10,c+1);
        }

        return helper(n/10,c);
    }
    
}
