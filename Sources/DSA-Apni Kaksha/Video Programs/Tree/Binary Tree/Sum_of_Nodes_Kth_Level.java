//https://www.codingninjas.com/codestudio/problems/kth-level_920333?leftPanelTab=0

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Sum_of_Nodes_Kth_Level {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(sumAtKthLevel(root, 2));
    }

    // before copying the code to the problem editor modify the
    // function according to the generic type of the editor.
    public static int sumAtKthLevel(TreeNode root, int k) {

        // Write your code here

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int sum = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int curr_sum = 0;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                curr_sum += temp.data;

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            if (level == k) {
                sum = curr_sum;
                break;
            }
        }

        return sum;
    }
}
