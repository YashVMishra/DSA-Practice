import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Construct_BST_from_Postorder {
    public static void main(String[] args) {
        int[] postorder = { 1, 7, 5, 50, 40, 10 };
        Node root = constructTree(postorder, postorder.length);
        Arrays.sort(postorder);

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i : postorder) {
            list1.add(i);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root, list2);

        System.out.println(list1);
        System.out.println(list2);
    }

    // since the driver code of this problem does not import somne
    public static Node constructTree(int postorder[], int n) {
        // Add your code here.
        int[] inorder = new int[postorder.length];
        for (int i = 0; i < inorder.length; i++) {
            inorder[i] = postorder[i];
        }

        Arrays.sort(inorder);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public static Node buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            HashMap<Integer, Integer> map) {

        if (ps > pe || is > ie) {
            return null;
        }

        Node root = new Node(postorder[pe]);

        int inRoot = map.get(root.data);
        int leftSize = inRoot - is;

        root.left = buildTree(inorder, is, inRoot - 1, postorder, ps, ps + leftSize - 1, map);
        root.right = buildTree(inorder, inRoot + 1, ie, postorder, ps + leftSize, pe - 1, map);

        return root;
    }

    public static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
