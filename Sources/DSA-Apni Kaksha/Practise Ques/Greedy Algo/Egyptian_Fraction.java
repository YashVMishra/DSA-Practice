//https://www.geeksforgeeks.org/greedy-algorithm-egyptian-fraction/

public class Egyptian_Fraction {
    public static void main(String[] args) {
        egyptian(2, 3);
    }

    public static void egyptian(int nr, int dr) {
        if (nr == 0 || dr == 0) {
            return;
        }

        // If numerator divides denominator,
        // then simple division makes
        // the fraction in 1/n form
        if (dr % nr == 0) {
            System.out.print(("1/" + dr / nr));
            return;
        }

        // If denominator divides numerator,
        // then the given number is not fraction
        if (nr % dr == 0) {
            System.out.print(nr / dr);
            return;
        }

        // If numerator is more than denominator
        if (nr > dr) {
            System.out.print(nr / dr + "  ");
            egyptian(nr % dr, dr);
            return;
        }

        // We reach here dr > nr and dr%nr
        // is non-zero. Find ceiling of
        // dr/nr and print it as first
        // fraction
        int n = dr / nr + 1; // finds the floor for us
        System.out.print("1/" + n + "  ");

        // recur for the remaining part.
        egyptian(nr * n - dr, n * dr);
    }
}
