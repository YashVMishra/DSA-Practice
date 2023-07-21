// https://leetcode.com/problems/asteroid-collision/description/

import java.util.Arrays;
import java.util.Stack;

public class Asteroid_Collision {
    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean insert = true;

            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {

                // If the top asteroid in the stack is smaller, then it will explode.
                // Hence pop it from the stack, also continue with the next asteroid in the
                // stack.
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                }

                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to
                // the stack.
                else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                insert = false;
                break;
            }

            if (insert) {
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.peek();
            st.pop();
        }

        return ans;
    }
}