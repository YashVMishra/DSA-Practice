//https://www.geeksforgeeks.org/calculate-square-of-a-number-without-using-and-pow/#:~:text=Given%20an%20integer%20n%2C%20calculate,*%2C%20%2F%20and%20pow().&text=A%20Simple%20Solution%20is%20to%20repeatedly%20add%20n%20to%20result.

public class Square {
    public static void main(String[] args) {
        System.out.println(square(11));
    }

    // without using *, / or pow() func
    public static int square(int num) {
        if (num == 0) {
            return 0;
        }

        int ans = 0;
        if (num % 2 == 0) {
            ans = 4 * square(num >> 1);
        }

        else {
            ans = 4 * square((int) (Math.floor(num >> 1))) + 4 * (int) (Math.floor(num >> 1)) + 1;
        }

        return ans;
    }
}
