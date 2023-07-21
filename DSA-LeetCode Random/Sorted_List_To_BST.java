//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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

public class Sorted_List_To_BST {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        helper(root);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode mid = mid(head);
        TreeNode root = new TreeNode(mid.val);

        if (head == mid) {
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    // returns the mid node in LL.
    public static ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    // display the tree.
    public static void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + "   ");
        helper(root.left);
        helper(root.right);
    }
}
