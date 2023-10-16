// https://leetcode.com/problems/pascals-triangle-ii/description/?envType=daily-question&envId=2023-10-16

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle_2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> res = getRow(rowIndex);

        System.out.println(res);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> pre = null;

        for (int i = 1; i <= rowIndex + 1; i++) {
            res = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    res.add(1);
                } else {
                    res.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = res;
        }

        return res;
    }
}
