import javax.swing.tree.TreeNode;

public class MinAbsDiffBST {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public static class TreeNode {
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


    // using dfs recursion
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return min;
        }
        getMinimumDifference(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }

    public static void main(String[] args){
        MinAbsDiffBST obj = new MinAbsDiffBST();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(obj.getMinimumDifference(root));

        obj = new MinAbsDiffBST();
        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        System.out.println(obj.getMinimumDifference(root));
    }
}
