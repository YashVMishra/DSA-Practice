//https://practice.geeksforgeeks.org/problems/counting-sort/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class Count_Sort {
    public static void main(String[] args) {
        String str = "geeksforgeeks";

        int[] arr = new int[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (str.charAt(i));
        }

        int[] ans = countSort(arr);
        ;
        String temp = "";

        for (int i = 0; i < ans.length; i++) {
            temp = temp + (char) (ans[i]);
        }

        System.out.println(temp);
    }

    public static int[] countSort(int[] arr) {

        // finding the max element from the array/
        int max = maxElement(arr);

        // creating an array of size max+1
        int[] count = new int[max + 1];

        // finding the count of every element of the original array.
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // modifying the count array that is to count[i] is the sum of the
        // count[i]+count[i-1]
        // this way we can evaluate the correct position at which the
        // element of the original array will be.
        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] += count[i];
        }

        // creating the new ans array so that we can store the sorted element in correct
        // order.
        int[] ans = new int[arr.length];

        // now we traverse the original array from the behind and we will
        // find the element of the original array and decrease its value in the count
        // by one and place that element in the ans array at the index of the decreased
        // count.
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i];

            count[index]--;

            ans[count[index]] = index;
        }

        return ans;

    }

    public static int maxElement(int[] arr) {
        int max = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

}
