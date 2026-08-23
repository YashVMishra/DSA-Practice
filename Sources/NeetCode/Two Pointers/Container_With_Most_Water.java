public class Container_With_Most_Water {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int leftHeight = 0, rightHeight = height.length - 1;
        int area = Integer.MIN_VALUE;

        while (leftHeight < rightHeight) {
            int length = Math.min(height[leftHeight], height[rightHeight]);
            int breadth = rightHeight - leftHeight;

            area = Math.max(area, length * breadth);

            if (height[leftHeight] < height[rightHeight]) {
                leftHeight++;
            } else {
                rightHeight--;
            }
        }

        return area;
    }
}
