//Here we have used Pair as a structure so that we can return 
//multiple values from a single function.

public class Max_and_Min {

    static class Pair {
        int max;
        int min;
    }

    public static void main(String[] args) {
        int[] arr = { 1000, 11, 445, 1, 330, 3000 };
        Pair ob = compute(arr);
        System.out.println("Max = " + ob.max);
        System.out.println("Min = " + ob.min);
    }

    public static Pair compute(int[] arr) {
        Pair ob = new Pair();

        if (arr.length == 1) {
            ob.max = arr[0];
            ob.min = arr[0];
            return ob;
        }

        if (arr[0] > arr[1]) {
            ob.max = arr[0];
            ob.min = arr[1];
        }

        else {
            ob.max = arr[0];
            ob.min = arr[1];
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > ob.max) {
                ob.max = arr[i];
            }

            if (arr[i] < ob.min) {
                ob.min = arr[i];
            }
        }
        return ob;
    }
}
