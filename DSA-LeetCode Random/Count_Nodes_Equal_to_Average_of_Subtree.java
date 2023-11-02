// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/?envType=daily-question&envId=2023-11-02

class Pair<K, V> {
    private K key;
    private V value;

    public Pair() {
        this.key = null;
        this.value = null;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return this.key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return this.value;
    }
}

public class Count_Nodes_Equal_to_Average_of_Subtree {
    private static int ans = 0;
    private static int result = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        averageOfSubtree(root);

        System.out.println(ans);
    }

    // calls the solve function.
    public static int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        solve(root);
        return ans;
    }

    // call the countNodes and sumOfNodes function.
    public static void solve(TreeNode root) {
        if (root == null) {
            return;
        }

        if (sumOfNodes(root) / countNodes(root) == root.val) {
            ans++;
        }

        solve(root.left);
        solve(root.right);
    }

    // function to count the number of nodes in the subtree.
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }

    // function to calculate the sum of nodes in the subtree.
    public static int sumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);

        return left + right + root.val;
    }

    // ----------------------------------------------------------------------------------

    public static int averageOfSubtree_2(TreeNode root) {
        solve_2(root);
        return result;
    }

    private static Pair<Integer, Integer> solve_2(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> left = solve_2(root.left);
        Pair<Integer, Integer> right = solve_2(root.right);

        int leftSum = left.getKey();
        int leftCount = left.getValue();

        int rightSum = right.getKey();
        int rightCount = right.getValue();

        int SUM = leftSum + rightSum + root.val;
        int COUNT = leftCount + rightCount + 1;

        int avg = SUM / COUNT;

        if (avg == root.val) {
            result++;
        }

        return new Pair<>(SUM, COUNT);
    }
}