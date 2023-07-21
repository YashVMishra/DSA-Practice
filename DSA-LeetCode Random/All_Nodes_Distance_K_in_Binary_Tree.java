//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class All_Nodes_Distance_K_in_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(distanceK(root, root.left, 2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (currLevel == k) {
                break;
            }

            currLevel++;

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                }

                if (current.right != null && visited.get(current.right) == null) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                }

                if (parents.get(current) != null && visited.get(parents.get(current)) == null) {
                    q.offer(parents.get(current));
                    visited.put(parents.get(current), true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            ans.add(current.val);
        }

        return ans;
    }

    public static void markParents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode temp = q.poll();

            if (temp.left != null) {
                map.put(temp.left, temp);
                q.offer(temp.left);
            }

            if (temp.right != null) {
                map.put(temp.right, temp);
                q.offer(temp.right);
            }
        }
    }
}
