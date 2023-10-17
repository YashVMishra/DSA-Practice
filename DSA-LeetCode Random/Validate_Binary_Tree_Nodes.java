// https://leetcode.com/problems/validate-binary-tree-nodes/description/?envType=daily-question&envId=2023-10-17

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Validate_Binary_Tree_Nodes {
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = { 1, 0, 3, -1 };
        int[] rightChild = { -1, -1, -1, -1 };

        boolean res = validateBinaryTreeNodes(n, leftChild, rightChild);

        System.out.println(res);
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> parentToChildren = new HashMap<>();
        Map<Integer, Integer> childToParent = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int node = i;
            int leftChildNode = leftChild[i];
            int rightChildNode = rightChild[i];

            if (leftChildNode != -1) {
                parentToChildren.computeIfAbsent(node, k -> new ArrayList<>()).add(leftChildNode);

                if (childToParent.containsKey(leftChildNode)) {
                    return false;
                } else {
                    childToParent.put(leftChildNode, node);
                }
            }

            if (rightChildNode != -1) {
                parentToChildren.computeIfAbsent(node, k -> new ArrayList<>()).add(rightChildNode);

                if (childToParent.containsKey(rightChildNode)) {
                    return false;
                } else {
                    childToParent.put(rightChildNode, node);
                }
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) {
                if (root != -1) {
                    return false;
                } else {
                    root = i;
                }
            }
        }

        if (root == -1) {
            return false;
        }

        /*
         * You might be thinking, if we already checked that there is only one root
         * above
         * and every child has one parent only, why do we need to traverse and check
         * again
         * for components ?
         * 
         * There can be cases where you find that only one node is missing from
         * child_to_parent map
         * which you will assume as root but that root will belong to a separate
         * component.
         * For example :
         * 4
         * [1,0,3,-1]
         * [-1,-1,-1,-1]
         * 
         */

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        queue.add(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : parentToChildren.getOrDefault(node, Collections.emptyList())) {
                if (!visited[child]) {
                    visited[child] = true;
                    count++;
                    queue.add(child);
                }
            }
        }

        return count == n; // we should be able to visit all nodes during BFS/DFS
    }
}
