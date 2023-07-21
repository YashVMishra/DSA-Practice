//https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/description/

import java.util.ArrayList;
import java.util.Arrays;

public class Find_the_Longest_Valid_Obstacle_Course_at_Each_Position {
    public static void main(String[] args) {
        int[] obstacles = { 3, 1, 5, 6, 4, 2 };
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(obstacles)));
    }

    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ans = new int[obstacles.length];
        ArrayList<Integer> list = new ArrayList<>();

        int index = 0;
        for (int obstacle : obstacles) {
            if (list.isEmpty() || obstacle >= list.get(list.size() - 1)) {
                list.add(obstacle);
                ans[index] = list.size();
                index++;
            }

            else {
                int firstIndex = firstGenerator(list, obstacle);
                list.set(firstIndex, obstacle);
                ans[index] = firstIndex + 1;
                index++;
            }
        }

        return ans;
    }

    // finds the upper bound that is index of first element
    // greater than key.
    public static int firstGenerator(ArrayList<Integer> list, int key) {
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > key) {
                index = i;
                break;
            }
        }

        return index;
    }
}
