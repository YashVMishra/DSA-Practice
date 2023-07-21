//https://practice.geeksforgeeks.org/problems/common-elements1132/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.HashSet;
import java.util.ArrayList;

public class Common_Elements {
    public static void main(String[] args) {
        System.out.println(commonElements(new int[] { 3, 3, 3 }, new int[] { 3, 3, 3 }, new int[] { 3, 3, 3 }));
    }

    public static ArrayList<Integer> commonElements(int A[], int B[], int C[]) {
        // code here

        HashSet<Integer> hs_1 = new HashSet<>();
        HashSet<Integer> hs_2 = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            hs_1.add(A[i]);
        }

        for (int i = 0; i < B.length; i++) {
            hs_2.add(B[i]);
        }

        for (int i = 0; i < C.length; i++) {
            if (hs_1.contains(C[i]) && hs_2.contains(C[i]) && !list.contains(C[i])) {
                list.add(C[i]);
            }
        }

        return list;
    }
}
