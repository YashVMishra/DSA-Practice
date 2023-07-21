/*
  WAP to check whether a string is palindrome or not.
 */

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the String : ");
        String name = sc.nextLine();
        if (name == null) {
            System.out.println("Not Palindrome");
        } else {
            if (isPalindrome(name.toLowerCase())) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not Palindrome");
            }
        }
    }

    static boolean isPalindrome(String str){
        if(str.length()==0){
            return true;
        }
        int start=0;
        int end= str.length()-1;
        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }

            else {
                start++;
                end--;
            }
        }

        return true;
    }
}
