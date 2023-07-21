//Check whether the array is sorted or not using recursion. 

class Sorted_Array {
    public static void main(String[] args) {
        System.out.println(sorted(new int[] { 1, 2, 1, 4, 5 }, 0));
    }

    public static boolean sorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }

        else {
            return (arr[index] < arr[index + 1]) && sorted(arr, index + 1);
        }
    }
}