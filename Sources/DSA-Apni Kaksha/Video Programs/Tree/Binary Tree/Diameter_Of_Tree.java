public class Diameter_Of_Tree {
    public static void main(String[] args) {
        int[] preOrder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(preOrder);
        System.out.println(diameter(root));

        TreeInfo ans = diameter_2(root);
        System.out.println(ans.dia);
    }

    // uses O(n^2).
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.right) + height(root.left) + 1;

        return Math.max(dia1, Math.max(dia2, dia3));
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int righHeight = height(root.right);

        return (Math.max(leftHeight, righHeight) + 1);
    }

    static class TreeInfo {
        int ht;
        int dia;

        public TreeInfo(int ht, int dia) {
            this.ht = ht;
            this.dia = dia;
        }
    }

    // uses O(n).
    public static TreeInfo diameter_2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter_2(root.left);
        TreeInfo right = diameter_2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht + 1;

        int myDia = Math.max(dia1, Math.max(dia2, dia3));

        TreeInfo ans = new TreeInfo(myHeight, myDia);
        return ans;
    }
}
