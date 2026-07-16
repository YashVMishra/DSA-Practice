import java.util.Arrays;

public class Two_Sum_2_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    // take 2 pointers of left and right, one from start and one from last
    // take the sum of their value, if the sum is greater than target then reduce
    // the right index as its on the greater side else if smaller then increase the
    // left index as its on the smaller side.
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[] { -1, -1 };
        }

        int leftIndex = 0, rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int currentSum = numbers[leftIndex] + numbers[rightIndex];

            if (currentSum == target) {
                return new int[] { leftIndex + 1, rightIndex + 1 };
            } else if (currentSum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return new int[] { -1, -1 };
    }
}
