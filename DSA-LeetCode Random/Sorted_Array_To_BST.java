//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

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

public class Sorted_Array_To_BST {
    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode root = sortedArrayToBST(nums);
        preorderDisplay(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int start = 0;
        int end = nums.length - 1;
        return createBST(nums, start, end);
    }

    public static TreeNode createBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = createBST(nums, start, mid - 1);
        root.right = createBST(nums, mid + 1, end);

        return root;
    }

    public static void preorderDisplay(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderDisplay(root.left);
        preorderDisplay(root.right);
    }
}
