//https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan&id=level-2

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Path_Sum_3 {

    static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;

        System.out.println(pathSum(root, targetSum));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    // taking the sum variable as long to prevent overflow.
    public static void dfs(TreeNode root, long sum) {
        if (root == null) {
            return;
        }

        calculateSum(root, sum);

        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    // we cannot pass sum-root.val and check sum == 0 as it will not consider
    // the leaf node values and when the value becomes zero then it will
    // return from the first if condition.
    // so use a temp variable to check the sum.
    public static void calculateSum(TreeNode root, long sum) {
        if (root == null) {
            return;
        }

        long temp = sum - root.val;
        if (temp == 0) {
            ans++;
        }

        calculateSum(root.left, temp);
        calculateSum(root.right, temp);
    }
}
