/*
 WAP to print all the three digits armstrong number
 */
import java.util.Scanner;

public class Armstrong_Number {
    public static void main(String[] args) {
        for (int i=100;i<=999;i++){
            if(checkArmstrong(i)){
                System.out.println(i + " is an Armstrong Number");
            }
        }
    }

     static boolean checkArmstrong(int num) {
        int value=num;
        int new_num=0;
        while(value>0){
            int rem=value%10;
            new_num=new_num+(rem*rem*rem);
            value=value/10;
        }
        if(new_num==num)
            return true;
        else
            return false;
    }
}
