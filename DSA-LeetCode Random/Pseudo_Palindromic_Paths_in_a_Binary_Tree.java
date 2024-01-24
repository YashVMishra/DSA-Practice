// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/?envType=daily-question&envId=2024-01-24

public class Pseudo_Palindromic_Paths_in_a_Binary_Tree {
    private static int result = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println(pseudoPalindromicPaths(root));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        int[] temp = new int[10];
        solve(root, temp);
        return result;
    }

    private static void solve(TreeNode root, int[] temp) {
        if (root != null) {
            temp[root.val]++;

            if (root.left == null && root.right == null) {
                int oddFreq = 0;
                for (int i = 1; i <= 9; i++) {
                    if (temp[i] % 2 != 0) {
                        oddFreq++;
                    }
                }

                result += oddFreq <= 1 ? 1 : 0;
            }

            solve(root.left, temp);
            solve(root.right, temp);

            temp[root.val]--;
        }
    }
}
