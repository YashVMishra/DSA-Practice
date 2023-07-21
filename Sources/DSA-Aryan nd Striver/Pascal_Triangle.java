//https://leetcode.com/problems/pascals-triangle/description/

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                }

                else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = row;
            res.add(row);
        }

        return res;
    }
}
