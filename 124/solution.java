/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPartial(root);
        return maxSum;
    }
    
    private int maxPartial(TreeNode root) {
        int result = 0;
        if (root == null) return result;
        int leftMaxPartial = maxPartial(root.left);
        int rightMaxPartial = maxPartial(root.right);
        result = Math.max(Math.max(leftMaxPartial, rightMaxPartial) + root.val, 0);
        maxSum = Math.max(maxSum, leftMaxPartial + rightMaxPartial + root.val);
        return result;
    }
}
