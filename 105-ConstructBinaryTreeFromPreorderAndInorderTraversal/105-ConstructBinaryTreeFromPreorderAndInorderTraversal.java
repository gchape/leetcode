// Last updated: 8/23/2026, 12:08:11 AM
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();

            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty()
                        && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }

                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }

        return root;
    }
}