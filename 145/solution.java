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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Set<TreeNode> seen = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (stack.size() > 0) {
            TreeNode top = stack.getFirst();
            if (!seen.contains(top)) {
                seen.add(top);
                if (top.right != null) stack.addFirst(top.right);
                if (top.left != null) stack.addFirst(top.left);
            } else {
                stack.removeFirst();
                result.add(top.val);
            }
        }
        return result;
    }
}
