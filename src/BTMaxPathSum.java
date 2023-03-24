public class BTMaxPathSum {

    int maxSum = Integer.MIN_VALUE;

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

    public int maxPathSum(TreeNode root){
        getMaxSum(root);
        return maxSum;
    }

    public int getMaxSum(TreeNode root){
        if(root == null) return 0;
        // left
        int left = Math.max(0, getMaxSum(root.left));
        //right
        int right = Math.max(0, getMaxSum(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }



    public static void main(String[] args){
        BTMaxPathSum obj = new BTMaxPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(obj.maxPathSum(root));
        obj = new BTMaxPathSum();
        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.maxPathSum(root));
    }

}
