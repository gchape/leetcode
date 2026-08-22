// Last updated: 8/23/2026, 12:08:04 AM
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

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return currentSum + root.val;
        }

        currentSum = (currentSum + root.val) * 10;

        return sumNumbers(root.left, currentSum) +
                sumNumbers(root.right, currentSum);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}