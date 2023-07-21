//https://leetcode.com/problems/container-with-most-water/description/

public class Most_Water {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(maxArea_2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    // logic is correct but uses O(n^2) TC
    public static int maxArea(int[] height) {
        int max_area = 0;

        for (int i = 0; i < height.length; i++) {
            int count = 1;

            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[j], height[i]);
                max_area = Math.max(max_area, min * count);
                count++;
            }
        }

        return max_area;
    }

    // uses linear time TC
    public static int maxArea_2(int[] height) {
        int max_area = 0;

        int a_pointer = 0;
        int b_pointer = height.length - 1;

        while (a_pointer < b_pointer) {
            if (height[a_pointer] < height[b_pointer]) {
                max_area = Math.max(max_area, height[a_pointer] * (b_pointer - a_pointer));
                a_pointer++;
            }

            else {
                max_area = Math.max(max_area, height[b_pointer] * (b_pointer - a_pointer));
                b_pointer--;
            }
        }

        return max_area;
    }
}
