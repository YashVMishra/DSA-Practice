/*
Given an integer num, return the number of steps to reduce it to zero.
In one step, if the current number is even, you have to divide it by 2, 
otherwise, you have to subtract 1 from it.
Example:-
Input: num = 14
Output: 6
Explanation: 
Step 1) 14 is even; divide by 2 and obtain 7. 
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3. 
Step 4) 3 is odd; subtract 1 and obtain 2. 
Step 5) 2 is even; divide by 2 and obtain 1. 
Step 6) 1 is odd; subtract 1 and obtain 0.
*/

public class Number_of_Steps_to_Zero{
    public static void main(String[]args){
        System.out.println(numberOfSteps(14));
    }

    public static int numberOfSteps(int num) {
        return helper(num, 0);
    }
    
    public static int helper(int n, int c){
        if(n==0){
            return c;
        }
        
        int rem=n%2;
        if(rem==0){
            return helper(n/2,c+1);
        }
        
        else {
            return helper(n-1,c+1);
        }
    }
}