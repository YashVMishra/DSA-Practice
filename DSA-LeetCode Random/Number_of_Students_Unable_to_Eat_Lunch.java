// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/?envType=daily-question&envId=2024-04-08

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Number_of_Students_Unable_to_Eat_Lunch {
    public static void main(String[] args) {
        int[] students = { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = { 1, 0, 0, 0, 1, 1 };

        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
        }

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        int totalStudentsEaten = 0;
        int counter = 0;

        while (true) {
            if (stack.peek() == queue.peek()) {
                totalStudentsEaten++;
                stack.pop();
                queue.poll();
                counter = 0;
            } else {
                counter++;
                queue.offer(queue.poll());
            }

            if (counter == queue.size()) {
                break;
            }
        }

        return students.length - totalStudentsEaten;
    }
}
