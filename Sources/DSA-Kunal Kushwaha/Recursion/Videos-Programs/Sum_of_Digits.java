/*
WAP to print the sum of digits.
*/

public class Sum_of_Digits {
    public static void main(String[]args){
        System.out.println(sum(3201));
    }

    public static int sum (int n){
        if(n<1){
            return n;
        }
        
        return (n%10) + sum(n/10);
    }
    
}
