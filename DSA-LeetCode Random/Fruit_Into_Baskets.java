//https://leetcode.com/problems/fruit-into-baskets/description/

public class Fruit_Into_Baskets {
    public static void main(String[] args) {
        int[] fruits = { 0, 1, 2, 2 };
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int last_fruit = -1;
        int second_last_fruit = -1;
        int curr_max = 0;
        int last_fruit_count = 0;
        int max = 0;

        for (int i : fruits) {
            if (i == last_fruit || i == second_last_fruit) {
                curr_max++;
            } else {
                curr_max = last_fruit_count + 1;
            }

            if (i == last_fruit) {
                last_fruit_count++;
            } else {
                last_fruit_count = 1;
            }

            if (i != last_fruit) {
                second_last_fruit = last_fruit;
                last_fruit = i;
            }

            max = Math.max(curr_max, max);
        }

        return max;

    }
}
