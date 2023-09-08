import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);

        for (List<Integer> row : res) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;

        for (int i = 1; i <= numRows; i++) {
            row = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = row;
            res.add(row);
        }

        return res;
    }
}