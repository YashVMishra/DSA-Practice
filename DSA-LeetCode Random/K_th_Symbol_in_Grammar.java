// https://leetcode.com/problems/k-th-symbol-in-grammar/?envType=daily-question&envId=2023-10-25

public class K_th_Symbol_in_Grammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1));
        System.out.println(kthGrammar(2, 1));
        System.out.println(kthGrammar(2, 2));
    }

    public static int kthGrammar(int N, int K) {
        if (N == 1 && K == 1) {
            return 0;
        }

        int mid = (int) Math.pow(2, N - 1) / 2;

        if (K <= mid) {
            return kthGrammar(N - 1, K);
        }

        return 1 - kthGrammar(N - 1, K - mid);
    }
}
