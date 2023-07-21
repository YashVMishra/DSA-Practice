import java.util.Scanner;

public class Pattern_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of lines");
        int n=sc.nextInt();
        for(int i=1;i<=(2*n-1);i++){
            if(i<=5){
                for(int j=1;j<=i;j++){
                    System.out.print("* ");
                }
                System.out.println();
            }

            else {
                for(int j=1;j<=2*n-i;j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}
